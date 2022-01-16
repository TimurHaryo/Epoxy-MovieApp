package dependencies.libraries.production

import dependencies.version.ProdLibsVersion

object KoinLibs {
    const val koinCore = "io.insert-koin:koin-core:${ProdLibsVersion.koinVersion}"
    const val koinAndroid = "io.insert-koin:koin-android:${ProdLibsVersion.koinVersion}"
}