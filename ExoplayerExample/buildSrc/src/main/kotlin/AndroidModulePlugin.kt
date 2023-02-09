import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ApplicationPlugin


class AndroidModulePlugin: Plugin<Project> {

   /* val Project.android:
        get() = extensions.findByName("android") as? AndroidModulePlugin
            ?: error("Project '$name' is not an Android module")*/
    override fun apply(target: Project) {
        with(target) {
            androidConfig()
        }
    }

    private fun Project.androidConfig() {
        val android = (extensions.findByName("android") as ApplicationPlugin).run {
            println("ANDROID THIS $this")
            namespace = "com.example.presentation"
            compileSdk = 32
        }
        println("ANDROID $android")
        /*extensions.findByName("android").run {
            namespace = "com.example.presentation"
            compileSdk = 32

            defaultConfig {
                minSdk = 24
                targetSdk = 32

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                consumerProguardFiles("consumer-rules.pro")
            }

            buildTypes {
                release {
                    isMinifyEnabled = false
                    proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro")
                }
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }*/
    }
}