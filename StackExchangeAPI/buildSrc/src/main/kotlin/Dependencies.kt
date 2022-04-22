import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.coroutines() {
    val version = "1.3.4"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$version")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$version")
}

fun DependencyHandler.activityX() {
    implementation("androidx.activity:activity-ktx:1.1.0")
}

fun DependencyHandler.lifecycle() {
    val version = "2.2.0"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$version")
}

fun DependencyHandler.constraintLayout() {
    implementation("androidx.constraintlayout:constraintlayout:2.0.0-beta6")
}

fun DependencyHandler.hilt() {
    val dagger = "2.38.1"
    val hilt = "1.0.0-alpha01"
    implementation("com.google.dagger:hilt-android:$dagger")
    kapt("com.google.dagger:hilt-android-compiler:$dagger")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:$hilt")
    kapt("androidx.hilt:hilt-compiler:$hilt")
}

fun DependencyHandler.room() {
    val roomVersion = "2.2.5"
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    /*implementation "androidx.room:room-coroutines:$room_version"*/
    kapt("androidx.room:room-compiler:$roomVersion")
}

fun DependencyHandler.paging() {
    val pagingVersion = "3.1.1"
    implementation("androidx.paging:paging-runtime:$pagingVersion")
}

fun DependencyHandler.retrofit() {
    val version = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$version")
    implementation("com.squareup.retrofit2:converter-moshi:$version")
    implementation("com.squareup.okhttp3:logging-interceptor:4.8.0")
}

fun DependencyHandler.moshi() {
    val version = "1.13.0"
    implementation("com.squareup.moshi:moshi:$version")
    implementation("com.squareup.moshi:moshi-adapters:$version")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:$version")
}

fun DependencyHandler.glide() {
    val version = "4.11.0"
    implementation("com.github.bumptech.glide:glide:$version")
    implementation("com.github.bumptech.glide:recyclerview-integration:$version")
    kapt("com.github.bumptech.glide:compiler:$version")
}

fun DependencyHandler.mockWebService() {
    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.0")
}

fun DependencyHandler.mockito() {
    val version = "3.12.4"
    testImplementation("org.mockito:mockito-core:$version")
    testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
}

fun DependencyHandler.hamcrest() {
    testImplementation("org.hamcrest:hamcrest-library:2.2")
}

///////////////
// HELPERS:
///////////////

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

private fun DependencyHandler.androidTestImplementation(depName: String) {
    add("androidTestImplementation", depName)
}