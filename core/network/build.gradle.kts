plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.sds.myhealthconnect.core.network"
    compileSdk = 35
    defaultConfig { minSdk = 24 }
}
dependencies {
    implementation(libs.retrofit)
    implementation(libs.converter.moshi)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
}
