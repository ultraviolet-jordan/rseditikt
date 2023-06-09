rootProject.name = "rseditikt"

dependencyResolutionManagement {
    repositories(RepositoryHandler::mavenCentral)

    versionCatalogs {
        create("deps") {
            version("kotlin", "1.8.20")
            version("versions", "0.46.0")
            version("javafx", "0.0.13")

            plugin("jvm", "org.jetbrains.kotlin.jvm").versionRef("kotlin")
            plugin("versions", "com.github.ben-manes.versions").versionRef("versions")
            plugin("javafx", "org.openjfx.javafxplugin").versionRef("javafx")
        }
    }
}
