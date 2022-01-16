import core.Modules
import dependencies.libraries.production.CoreLibs
import dependencies.libraries.production.WidgetLibs

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = core.AppConfig.compileSdkVersion

    defaultConfig {
        minSdk = core.AppConfig.minSdkVersion
        targetSdk = core.AppConfig.targetSdkVersion
        versionCode = core.AppConfig.versionCode
        versionName = core.AppConfig.versionName

        testInstrumentationRunner = core.AppConfig.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = core.AppConfig.jvmTarget
    }
    buildFeatures {
        dataBinding = true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(Modules.core))

    implementation(CoreLibs.coreKtx)
    implementation(WidgetLibs.appCompat)
    implementation(WidgetLibs.material)
    implementation(WidgetLibs.constraintLayout)

    // Epoxy
    implementation(WidgetLibs.epoxyCore)
    implementation(WidgetLibs.epoxyDataBinding)
    kapt(WidgetLibs.epoxyProcessor)
}