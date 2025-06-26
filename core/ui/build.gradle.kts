plugins {
    alias(libs.plugins.seraphim.android.library.compose)
    alias(libs.plugins.seraphim.android.library)
}
android {
    namespace = "com.seraphim.core.ui"
}
dependencies {
    implementation(libs.napier.loggger)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.navigation3.ui)
    implementation(libs.androidx.lifecycle.viewmodel.navigation3)
}