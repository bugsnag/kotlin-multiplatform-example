plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
    id("com.bugsnag.android.gradle")
}

android {
    compileSdkVersion(28)

    defaultConfig {
        applicationId = "com.bugsnag.example.kotlinmp"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        setSourceCompatibility(JavaVersion.VERSION_1_8)
        setTargetCompatibility(JavaVersion.VERSION_1_8)
    }
}

dependencies {
    api(project(":common"))

    // kotlin jdk
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}")

    // google android libs
    implementation("androidx.appcompat:appcompat:${Versions.androidx}")
    implementation("com.google.android.material:material:${Versions.androidx}")

    // crash reporting
    implementation("com.bugsnag:bugsnag-android:${Versions.bugsnagAndroid}")
}
