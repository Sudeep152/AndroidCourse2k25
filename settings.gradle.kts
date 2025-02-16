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
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AndroidCourse2k25"
include(":app")
include(":day1")
include(":day2")
include(":day4")
include(":day5")
include(":day6")
include(":day7")
include(":day8")
include(":day9")
include(":day10")
include(":day11")
include(":day12")
include(":day13")
include(":musicapp")
