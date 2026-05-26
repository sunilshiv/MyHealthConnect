plugins { alias(libs.plugins.android.library) }
android { namespace = "com.sds.myhealthconnect.core.testing"; compileSdk = 35; defaultConfig { minSdk = 24 } }
dependencies { implementation(libs.junit) }
