import org.gradle.kotlin.dsl.support.kotlinCompilerOptions

plugins {
    alias(libs.plugins.seraphim.kotlin.multiplatform.library)
}
android {
    namespace = "com.seraphim.core.mmkv"
}
kotlin {
    jvmToolchain(21)
    compilerOptions {
        freeCompilerArgs.addAll(
            listOf(
                "-Xopt-in=kotlin.RequiresOptIn",
                "-Xopt-in=kotlin.ExperimentalStdlibApi",
                "-Xopt-in=kotlin.time.ExperimentalTime",
                "-Xopt-in=kotlinx.serialization.ExperimentalSerializationApi",
                "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-Xlint:-unused"
            )
        )
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.mmkv.kotlin)
            }
        }
        // 其他 sourceSet 配置
    }
}
