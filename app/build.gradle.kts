plugins {
    id("com.android.application")
}
android {
    namespace = "com.cheat.menu"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.cheat.menu"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
        }
    }
}
dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
}
