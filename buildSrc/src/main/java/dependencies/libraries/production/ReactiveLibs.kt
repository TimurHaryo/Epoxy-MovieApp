package dependencies.libraries.production

import dependencies.version.ProdLibsVersion

object ReactiveLibs {
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${ProdLibsVersion.coroutinesVersion}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${ProdLibsVersion.coroutinesVersion}"
}