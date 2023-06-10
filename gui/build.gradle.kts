@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    application
    alias(deps.plugins.jvm)
    alias(deps.plugins.javafx)
}

javafx {
    version = "18.0.2"
    modules = listOf("javafx.controls")
}

application {
    mainClass.set("rseditikt.gui.EditorKt")
}

dependencies {
    api(project(":cache"))
    api(project(":cache-osrs"))
    implementation(deps.guice)
}
