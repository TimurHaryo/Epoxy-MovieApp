package dependencies.libraries.production

import dependencies.version.ProdLibsVersion

object PluginLibs {
    const val classpathBuildGradle =
        "com.android.tools.build:gradle:${ProdLibsVersion.buildGradleVersion}"
    const val classpathKotlinPlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${ProdLibsVersion.kotlinVersion}"
}