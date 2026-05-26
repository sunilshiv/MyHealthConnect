plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.devtools.ksp)
}

android {
    namespace = "com.sds.myhealthconnect.features.home"
    compileSdk = 36
    defaultConfig { minSdk = 24 }
    buildFeatures { compose = true }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material.icons.extended)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(project(":core:ui"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:navigation"))
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}
