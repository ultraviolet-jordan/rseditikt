@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(deps.plugins.jvm)
}

dependencies {
    implementation(deps.openrs2.cache)
    implementation(deps.guice)
}
