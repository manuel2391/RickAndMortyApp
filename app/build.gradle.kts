plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Versions.compileSDK
    buildToolsVersion = Versions.buildTools

    defaultConfig {
        applicationId = "com.mg.rickandmortyapp"
        minSdk = Versions.minSDK
        targetSdk = Versions.targetSDK
        versionCode = Versions.appVersionCode
        versionName = Versions.appVersionName

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":common"))
    implementation(project(":common-ui"))

    // Kotlin
    implementation(Deps.kotlinStdLib)

    // AndroidX
    implementation(Deps.androidExt)
    implementation(Deps.composeUi)
    implementation(Deps.composeMaterial)
    implementation(Deps.composeUiPreviewTools)
    implementation(Deps.composeActivity)
    implementation(Deps.pallete)

    // Jetpack Navigation
    implementation(Deps.composeNavigation)

    // Jetpack Lifecycle
    implementation(Deps.lifecycle)
    implementation(Deps.viewModelLifecycle)

    // Dependency Injection
    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltCompiler)
    implementation(Deps.hiltNavigationCompose)

    // Concurrency
    implementation(Deps.coroutines)
    implementation(Deps.coroutinesAndroid)

    // Coil
    implementation(Deps.coil)

    // Memory Leaks
    debugImplementation(Deps.leakCanary)

    // Firebase
    implementation(Deps.firebaseAnalytics)
    implementation(Deps.firebaseCrashlytics)
    implementation(Deps.firebaseMessaging)

    // Testing
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.junitX)
    androidTestImplementation(Deps.espressoCore)
    androidTestImplementation(Deps.testRunner)
    androidTestImplementation(Deps.composeUiTest)

    // Debug
    debugImplementation(Deps.composeUiTools)
}

kapt {
    correctErrorTypes = true
}

hilt {
    enableAggregatingTask = true
}
