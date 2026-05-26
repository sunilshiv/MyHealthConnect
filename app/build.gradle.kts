plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.devtools.ksp)
}

android {
    namespace = "com.sds.myhealthconnect"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.sds.myhealthconnect"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.material)

    // Feature Modules
    implementation(project(":features:login"))
    implementation(project(":features:home"))
    implementation(project(":features:settings"))
    implementation(project(":features:appointment"))
    implementation(project(":features:consultation"))
    implementation(project(":features:prescription"))
    implementation(project(":features:profile"))
    implementation(project(":features:notification"))
    implementation(project(":features:records"))

    // Mini Apps
    implementation(project(":miniapps:mini-pharmacy"))
    implementation(project(":miniapps:mini-lab"))

    // Core Modules
    implementation(project(":core:common"))
    implementation(project(":core:ui"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:navigation"))

    // Data Module (Required for Repository implementations)
    implementation(project(":data"))

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
