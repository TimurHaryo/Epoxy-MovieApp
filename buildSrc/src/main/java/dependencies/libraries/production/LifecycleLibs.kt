package dependencies.libraries.production

import dependencies.version.ProdLibsVersion

object LifecycleLibs {
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${ProdLibsVersion.lifecycleKtxVersion}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${ProdLibsVersion.lifecycleKtxVersion}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${ProdLibsVersion.lifecycleKtxVersion}"
}