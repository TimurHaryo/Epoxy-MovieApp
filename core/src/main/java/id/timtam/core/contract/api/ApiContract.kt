package id.timtam.core.contract.api

import id.timtam.core.exception.Failure
import id.timtam.core.vo.Either
import retrofit2.Response

interface ApiContract {
    suspend fun <T> request(apiCall: suspend () -> Response<T>) : Either<Failure, T>
}