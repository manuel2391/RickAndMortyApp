object Versions {
    // Build Config
    const val minSDK = 25
    const val compileSDK = 32
    const val targetSDK = 32
    const val buildTools = "30.0.2"

    // App version
    const val appVersionCode = 1
    const val appVersionName = "0.0.1"

    // Plugins
    const val androidGradlePlugin = "7.2.0"
    const val googleServicesPlugin = "4.3.10"
    const val crashlyticsPlugin = "2.7.1"

    // Kotlin
    const val kotlin = "1.7.10"

    // Ktlint
    const val ktlint = "0.42.1"

    // Testing
    const val junit = "4.13.2"
    const val junitX = "1.1.3"
    const val espresso = "3.4.0"
    const val runner = "1.1.0"

    // AndroidX
    const val appCompat = "1.4.0-alpha03"
    const val androidExt = "1.7.0"
    const val compose = "1.2.1"
    const val composeCompiler = "1.3.0"
    const val activity = "1.4.0"

    // Jetpack
    const val navigation = "2.4.2"
    const val lifecycle = "2.4.1"
    const val viewModelLifecycle = "2.4.0-rc01"
    const val room = "2.4.0-alpha04"

    // Network
    const val retrofit = "2.9.0"
    const val okhttp = "4.9.0"
    const val moshi = "1.9.3"

    // Dependency Injection
    const val hilt = "2.42"
    const val hiltNavigationCompose = "1.0.0-alpha03"

    // Concurrency
    const val coroutines = "1.5.2"

    // Memory Leaks
    const val leakCanary = "2.9.1"

    // Firebase
    const val firebaseAnalytics = "17.5.0"
    const val firebaseCrashlytics = "17.2.1"
    const val firebaseMessaging = "20.2.4"

    // Other
    const val coil = "2.0.0"
    const val pallete = "1.0.0"
}

object Deps {
    // Plugins
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val googleServicesPlugin = "com.google.gms:google-services:${Versions.googleServicesPlugin}"
    const val crashlyticsPlugin = "com.google.firebase:firebase-crashlytics-gradle:${Versions.crashlyticsPlugin}"

    // Kotlin
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"

    // Ktlint
    const val ktlint = "com.pinterest:ktlint:${Versions.ktlint}"

    // Testing
    const val junit = "junit:junit:${Versions.junit}"
    const val junitX = "androidx.test.ext:junit:${Versions.junitX}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val testRunner = "androidx.test:runner:${Versions.runner}"
    const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"

    // AndroidX
    const val androidExt = "androidx.core:core-ktx:${Versions.androidExt}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeUiPreviewTools = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeUiTools = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.activity}"
    const val pallete = "androidx.palette:palette:${Versions.pallete}"

    // Jetpack Navigation
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.navigation}"

    // Jetpack Lifecycle
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val viewModelLifecycle = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.viewModelLifecycle}"

    // Jetpack Architecture
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomExt = "androidx.room:room-ktx:${Versions.room}"

    // Network
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val okhttp3Log = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

    // Dependency Injection
    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCore = "com.google.dagger:hilt-core:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"

    // Concurrency
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // Memory Leaks
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"

    // Firebase
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics:${Versions.firebaseAnalytics}"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics:${Versions.firebaseCrashlytics}"
    const val firebaseMessaging = "com.google.firebase:firebase-messaging:${Versions.firebaseMessaging}"

    // Other
    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"

}