plugins {
    alias(libs.plugins.seraphim.android.library.compose)
    alias(libs.plugins.seraphim.android.library)
}
android {
    namespace = "com.seraphim.babydiary.domain.route"
}
dependencies {
    implementation(libs.napier.loggger)
}