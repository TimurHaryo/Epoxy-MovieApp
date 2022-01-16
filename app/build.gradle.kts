import core.AppConfig
import core.Modules
import dependencies.libraries.production.CoreLibs
import dependencies.libraries.production.WidgetLibs
import dependencies.libraries.production.ReactiveLibs
import dependencies.libraries.test.TestLibs

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = AppConfig.compileSdkVersion

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
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

    implementation(project(Modules.core))
    implementation(project(Modules.uikit))
    implementation(project(Modules.component))

    implementation(CoreLibs.coreKtx)
    implementation(WidgetLibs.appCompat)
    implementation(WidgetLibs.material)
    implementation(WidgetLibs.constraintLayout)

    // Kotlin Coroutines - Asynchronous
    implementation(ReactiveLibs.coroutinesCore)
    implementation(ReactiveLibs.coroutinesAndroid)

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

    testImplementation(TestLibs.mockk)
    testImplementation(TestLibs.kotestRunner)
    testImplementation(TestLibs.kotestAssertions)
    testImplementation(TestLibs.kotestProperty)
}