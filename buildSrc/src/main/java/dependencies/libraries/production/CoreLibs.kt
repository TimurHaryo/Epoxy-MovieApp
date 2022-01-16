package dependencies.libraries.production

import dependencies.version.ProdLibsVersion

object CoreLibs {
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${ProdLibsVersion.kotlinVersion}"
    const val coreKtx = "androidx.core:core-ktx:${ProdLibsVersion.coreKtxVersion}"
}