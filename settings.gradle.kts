pluginManagement {
    includeBuild("build-logic")
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

rootProject.name = "Track Money"
include(":app")
include(":core:ui")
include(":core:designsystem")
include(":feature:home")
include(":feature:transaction")
include(":feature:overview")
include(":feature:debts")
include(":core:model")
include(":feature:categories")
include(":core:common")
