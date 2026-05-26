plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.google.devtools.ksp)
}

android {
    namespace = "com.sds.myhealthconnect.core.database"
    compileSdk = 35
    defaultConfig { minSdk = 24 }
}
dependencies {
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
}
