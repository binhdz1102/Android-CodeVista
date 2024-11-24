plugins {
    alias(libs.plugins.androiduwu.android.application)
    alias(libs.plugins.androiduwu.android.application.compose)
    alias(libs.plugins.androiduwu.android.application.jacoco)
    alias(libs.plugins.androiduwu.android.hilt)
    alias(libs.plugins.androiduwu.android.navigation)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
//    id("com.google.devtools.ksp") version "1.7.20-1.0.8"
}

android {
    namespace = "com.binhdz.androidcodevista"

    defaultConfig {
        applicationId = "com.binhdz.androidcodevista"

//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
//    packaging {
//        resources {
//            excludes += "/META-INF/{AL2.0,LGPL2.1}"
//        }
//    }
}


dependencies {
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.core.ktx)


    // bộ dependencies UT



    // bộ dependencies chạy app notes

    implementation("androidx.compose.material:material-icons-extended:1.5.0")

    // Coroutines
    val coroutineVersion = "1.7.1"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion")

    // Room
    val roomVersion = "2.5.2"
    implementation("androidx.room:room-runtime:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")

    // Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$roomVersion")

}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}