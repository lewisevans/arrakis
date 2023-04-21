import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.compose() {
    val composeBom = platform("androidx.compose:compose-bom:2023.03.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material:material")

    /*TEST*/
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    debugImplementation("androidx.compose.ui:ui-tooling")

    /*NOT USED*/
    val navigationComposeVersion = "2.5.3"
    implementation("androidx.navigation:navigation-compose:${navigationComposeVersion}")
}

fun DependencyHandler.coroutines() {
    val version = "1.3.9"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$version")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$version")
}

fun DependencyHandler.hiltCompose() {
    val hiltNavCompose = "1.0.0"
    implementation("androidx.hilt:hilt-navigation-compose:$hiltNavCompose")
    hilt()
}
fun DependencyHandler.hilt() {
    val daggerHilt = "2.45"
    implementation ("com.google.dagger:hilt-android:$daggerHilt")
    kapt ("com.google.dagger:hilt-compiler:$daggerHilt")
}

fun DependencyHandler.retrofit() {
    val version = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$version")
    implementation("com.squareup.retrofit2:converter-moshi:$version")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
}

/*fun DependencyHandler.moshi() {
    val version = "1.13.0"
    implementation("com.squareup.moshi:moshi:$version")
    implementation("com.squareup.moshi:moshi-adapters:$version")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:$version")
}*/

/*TEST*/

fun DependencyHandler.androidTest() {
    generalTest()
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

fun DependencyHandler.generalTest() {
    testImplementation("junit:junit:4.13.2")
    mockito()
}

fun DependencyHandler.mockito() {
    val version = "3.12.4"
    testImplementation("org.mockito:mockito-core:$version")
    testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
}

///////////////
// HELPERS:
///////////////

private fun DependencyHandler.implementation(dependency: Dependency) {
    add("implementation", dependency)
}

private fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}

private fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

private fun DependencyHandler.compileOnly(depName: String) {
    add("compileOnly", depName)
}

private fun DependencyHandler.api(depName: String) {
    add("api", depName)
}

private fun DependencyHandler.testImplementation(depName: String) {
    add("testImplementation", depName)
}

private fun DependencyHandler.androidTestImplementation(dependency: Dependency) {
    add("androidTestImplementation", dependency)
}

private fun DependencyHandler.androidTestImplementation(depName: String) {
    add("androidTestImplementation", depName)
}

private fun DependencyHandler.debugImplementation(depName: String) {
    add("debugImplementation", depName)
}
