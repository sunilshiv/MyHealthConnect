plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.hilt)
    alias(libs.plugins.google.devtools.ksp)
}

android {
    namespace = "com.sds.myhealthconnect.core.common"
    compileSdk = 36
    defaultConfig { minSdk = 24 }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}
