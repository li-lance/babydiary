plugins {
    alias(libs.plugins.lance.android.application)
    alias(libs.plugins.lance.android.application.compose)
    alias(libs.plugins.lance.android.application.flavors)
    alias(libs.plugins.lance.android.application.jacoco)
    alias(libs.plugins.lance.android.application.firebase)
    alias(libs.plugins.lance.hilt)
    alias(libs.plugins.baselineprofile)
    alias(libs.plugins.roborazzi)
    alias(libs.plugins.kotlin.serialization)
}
android {
    defaultConfig {
        applicationId = "com.lance.babydiary"
        versionCode = 8
        versionName = "0.1.2" // X.Y.Z; X = Major, Y = minor, Z = Patch level
    }
    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    namespace = "com.lance.babydiary"
}
dependencies {
    implementation(libs.androidx.core.ktx)
}