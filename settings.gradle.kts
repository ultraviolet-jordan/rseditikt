rootProject.name = "rseditikt"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven(url = "https://repo.openrs2.org/repository/openrs2-snapshots")
    }

    versionCatalogs {
        create("deps") {
            version("kotlin", "1.8.20")
            version("versions", "0.46.0")
            version("javafx", "0.0.13")
            version("openrs2", "0.1.0-SNAPSHOT")
            version("guice", "1.6.0")

            plugin("jvm", "org.jetbrains.kotlin.jvm").versionRef("kotlin")
            plugin("versions", "com.github.ben-manes.versions").versionRef("versions")
            plugin("javafx", "org.openjfx.javafxplugin").versionRef("javafx")

            library("openrs2-cache", "org.openrs2", "openrs2-cache").versionRef("openrs2")
            library("guice", "dev.misfitlabs.kotlinguice4", "kotlin-guice").versionRef("guice")
        }
    }
}

include("cache")
include("cache-osrs")
include("gui")
