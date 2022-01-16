import core.AppConfig
import dependencies.libraries.production.CoreLibs
import dependencies.libraries.production.WidgetLibs
import dependencies.libraries.production.ReactiveLibs
import dependencies.libraries.production.LifecycleLibs
import dependencies.libraries.production.NetworkLibs
import dependencies.libraries.debug.LoggerLibs

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = AppConfig.compileSdkVersion

    defaultConfig {
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
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
        jvmTarget = AppConfig.jvmTarget
    }
    buildFeatures {
        dataBinding = true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    implementation(CoreLibs.coreKtx)
    implementation(WidgetLibs.appCompat)
    implementation(WidgetLibs.material)

    // Retrofit & Gson
    implementation(NetworkLibs.retrofit)

    // Kotlin Coroutines - Asynchronous
    implementation(ReactiveLibs.coroutinesCore)
    implementation(ReactiveLibs.coroutinesAndroid)

    // Lifecycle Components
    implementation(LifecycleLibs.lifecycleRuntime)
    implementation(LifecycleLibs.lifecycleViewModel)
    implementation(LifecycleLibs.lifecycleLiveData)

    // Epoxy
    implementation(WidgetLibs.epoxyCore)
    implementation(WidgetLibs.epoxyDataBinding)
    kapt(WidgetLibs.epoxyProcessor)

    // Glide
    implementation(WidgetLibs.glide)
    kapt(WidgetLibs.glideCompiler)

    // Paris
    implementation(WidgetLibs.paris)
    kapt(WidgetLibs.parisProcessor)

    debugApi(LoggerLibs.timber)
}