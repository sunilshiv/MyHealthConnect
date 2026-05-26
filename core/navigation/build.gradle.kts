plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.sds.myhealthconnect.core.navigation"
    compileSdk = 35
    defaultConfig { minSdk = 24 }
}
dependencies {
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.hilt.navigation.compose)
}
