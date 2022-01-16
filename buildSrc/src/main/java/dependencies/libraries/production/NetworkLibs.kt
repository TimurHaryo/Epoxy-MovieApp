package dependencies.libraries.production

import dependencies.version.ProdLibsVersion

object NetworkLibs {
    const val okhttp3Logging = "com.squareup.okhttp3:logging-interceptor:${ProdLibsVersion.okhttp3Version}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${ProdLibsVersion.retrofitVersion}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${ProdLibsVersion.retrofitVersion}"
}