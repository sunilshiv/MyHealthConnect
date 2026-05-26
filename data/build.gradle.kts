plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.hilt)
    alias(libs.plugins.google.devtools.ksp)
}

android {
    namespace = "com.sds.myhealthconnect.data"
    compileSdk = 35
    defaultConfig { minSdk = 24 }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":core:database"))
    implementation(project(":core:network"))
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.kotlinx.coroutines.core)
}
