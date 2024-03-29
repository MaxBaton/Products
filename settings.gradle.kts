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
include(":features:menu:catalog:presentation")
include(":features:menu:cart:presentation")
include(":features:menu:discounts:presentation")
include(":features:menu:profile:presentation")
include(":features:menu:catalog:data")
include(":features:menu:catalog:domain")
include(":features:auth:api")
include(":features:menu:catalog:api")
