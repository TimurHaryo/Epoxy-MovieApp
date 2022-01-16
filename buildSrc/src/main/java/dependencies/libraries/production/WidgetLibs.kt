package dependencies.libraries.production

import dependencies.version.ProdLibsVersion

object WidgetLibs {
    const val appCompat = "androidx.appcompat:appcompat:${ProdLibsVersion.appCompatVersion}"
    const val material = "com.google.android.material:material:${ProdLibsVersion.materialVersion}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${ProdLibsVersion.constraintVersion}"
    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${ProdLibsVersion.swipeRefreshVersion}"
    const val glide = "com.github.bumptech.glide:glide:${ProdLibsVersion.glide_version}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${ProdLibsVersion.glide_version}"
    const val epoxyCore = "com.airbnb.android:epoxy:${ProdLibsVersion.epoxyVersion}"
    const val epoxyProcessor = "com.airbnb.android:epoxy-processor:${ProdLibsVersion.epoxyVersion}"
    const val epoxyDataBinding = "com.airbnb.android:epoxy-databinding:${ProdLibsVersion.epoxyVersion}"
    const val paris = "com.airbnb.android:paris:${ProdLibsVersion.parisVersion}"
    const val parisProcessor = "com.airbnb.android:paris-processor:${ProdLibsVersion.parisVersion}"
}