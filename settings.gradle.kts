pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ProductsTestEffectiveMobile"
include(":app")
include(":core:ui")
include(":core:navigation")
include(":core:contract:mvi")
include(":features:auth:domain")
include(":features:auth:data")
include(":features:auth:presentation")
include(":features:menu:host:presentation")
include(":features:menu:main:presentation")
