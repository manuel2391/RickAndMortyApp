plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = Versions.compileSDK

    defaultConfig {
        minSdk = Versions.minSDK
        targetSdk = Versions.targetSDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "API_URL", "\"https://rickandmortyapi.com/api/\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":common"))
    // Kotlin
    implementation(Deps.kotlinStdLib)

    // Dependency Injection
    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltCompiler)

    // Concurrency
    implementation(Deps.coroutines)
    implementation(Deps.coroutinesAndroid)

    // Network
    implementation(Deps.retrofit)
    implementation(Deps.moshiConverter)
    implementation(Deps.moshi)
    implementation(Deps.okhttp3Log)

    // Database
    implementation(Deps.room)
    kapt(Deps.roomCompiler)
    implementation(Deps.roomExt)
}