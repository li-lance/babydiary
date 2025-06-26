plugins {
    alias(libs.plugins.seraphim.android.library)
}
android {
    namespace = "com.seraphim.core.logger"
}
dependencies {
    implementation(libs.napier.loggger)
}