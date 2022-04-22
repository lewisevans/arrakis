plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    implementation("javax.inject:javax.inject:1")
    coroutines()
    mockito()
    hamcrest()
    testImplementation("junit:junit:4.13.2")
}