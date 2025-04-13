plugins {
    alias(libs.plugins.lance.kotlin.multiplatform.library)
    alias(libs.plugins.lance.openapi.generator)
}
android {
    namespace = "com.lance.shared"
    compileSdk = 35
}
kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.datetime)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.client.serialization.json)
                implementation(libs.ktor.client.logging)
                implementation(libs.ktor.client.auth)
            }
            kotlin.srcDir("build/openapi/src/main/kotlin")
        }
        androidMain.dependencies {
            implementation(libs.ktor.client.android)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.ios)
        }
    }
}