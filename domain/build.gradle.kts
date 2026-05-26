plugins { alias(libs.plugins.android.library) }
android { namespace = "com.sds.myhealthconnect.domain"; compileSdk = 35; defaultConfig { minSdk = 24 } }
dependencies { implementation(libs.kotlinx.coroutines.core) }
