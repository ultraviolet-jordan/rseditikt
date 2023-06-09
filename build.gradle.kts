plugins {
    application
    alias(deps.plugins.jvm)
    alias(deps.plugins.versions)
    alias(deps.plugins.javafx)
}

application {
    mainClass.set("rseditikt.EditorKt")
}

javafx {
    version = "18.0.2"
    modules = listOf("javafx.controls")
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
}
