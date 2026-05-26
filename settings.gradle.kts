pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MyHealthConnect"
include(":app")

// Core modules
include(":core:common")
include(":core:utils")
include(":core:ui")
include(":core:designsystem")
include(":core:navigation")
include(":core:network")
include(":core:database")
include(":core:datastore")
include(":core:auth")
include(":core:security")
include(":core:analytics")
include(":core:notification")
include(":core:workmanager")
include(":core:sync")
include(":core:files")
include(":core:webrtc")
include(":core:ble")
include(":core:location")
include(":core:pdf")
include(":core:player")
include(":core:testing")
include(":core:config")

// Feature modules
include(":features:login")
include(":features:home")
include(":features:settings")
include(":features:appointment")
include(":features:consultation")
include(":features:prescription")
include(":features:profile")
include(":features:notification")
include(":features:records")

// Mini Apps
include(":miniapps:mini-pharmacy")
include(":miniapps:mini-lab")

// Shared modules
include(":domain")
include(":data")
include(":sdk")
include(":platform")

// Others
include(":dynamic-feature")
include(":benchmark")
