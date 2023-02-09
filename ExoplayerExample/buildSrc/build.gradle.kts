import org.gradle.kotlin.dsl.`kotlin-dsl`
plugins {
    `kotlin-dsl`
}
repositories {
    mavenCentral()
}
gradlePlugin {
    plugins {
        register("greet-plugin") {
            id = "greet-plugin"
            implementationClass = "AndroidModulePlugin"
        }
        create("base-android") {
            id = "base-android"
            implementationClass = "AndroidModulePlugin"
        }
    }
}