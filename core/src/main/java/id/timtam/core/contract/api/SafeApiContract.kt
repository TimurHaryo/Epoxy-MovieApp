package id.timtam.core.contract.api

import id.timtam.core.exception.Failure
import id.timtam.core.exception.RequestResults
import id.timtam.core.extension.hasEmptyBody
import id.timtam.core.extension.isTotallySuccess
import id.timtam.core.vo.Either
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

open class SafeApiContract : ApiContract {

    override suspend fun <T> request(apiCall: suspend () -> Response<T>): Either<Failure, T> {
        return try {
            val response = apiCall.invoke()

            when {
                response.isTotallySuccess() -> Either.Success(response.body()!!)
                response.hasEmptyBody() -> parseError(
                    Failure(response.code(), Throwable(response.message()))
                )
                response.code() in 300..599 -> parseError(
                    Failure(response.code(), Throwable(response.message()))
                )
                else -> parseError(
                    Failure(response.code(), Throwable(response.message()))
                )
            }
        } catch (throwable: Throwable) {
            when(throwable) {
                is UnknownHostException -> parseError(
                    Failure(RequestResults.NO_CONNECTION, throwable)
                )
                is ConnectException -> parseError(
                    Failure(RequestResults.NO_CONNECTION, throwable)
                )
                is SocketTimeoutException -> parseError(
                    Failure(RequestResults.TIMEOUT, throwable)
                )
                else -> parseError(
                    Failure(RequestResults.UNKNOWN_ERROR, throwable)
                )
            }
        }
    }

    private fun parseError(failure: Failure) : Either.Error<Failure> = Either.Error(failure)
}