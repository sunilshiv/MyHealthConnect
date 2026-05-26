plugins { alias(libs.plugins.android.library) }
android { namespace = "com.sds.myhealthconnect.core.location"; compileSdk = 35; defaultConfig { minSdk = 24 } }
dependencies { implementation(libs.play.services.location) }
