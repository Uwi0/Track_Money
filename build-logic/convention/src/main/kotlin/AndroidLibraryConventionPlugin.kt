import com.android.build.api.variant.LibraryAndroidComponentsExtension
import com.android.build.gradle.LibraryExtension
import com.kakapo.trackMoney.configureFlavors
import com.kakapo.trackMoney.configureGradleManagedDevices
import com.kakapo.trackMoney.configureKotlinAndroid
import com.kakapo.trackMoney.configureKotlinAndroidToolchain
import com.kakapo.trackMoney.configurePrintApksTask
import com.kakapo.trackMoney.disableUnnecessaryAndroidTests
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            configureKotlinAndroidToolchain()
            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 33
                configureFlavors(this)
                buildTypes {
                    debug {
                        isMinifyEnabled = false
                        buildConfigField("Boolean", "DEBUG_MODE", "true")
                    }
                    release {
                        release {
                            isMinifyEnabled = true
                            buildConfigField("Boolean", "DEBUG_MODE", "false")
                        }
                    }
                }
                configureGradleManagedDevices(this)
            }
            extensions.configure<LibraryAndroidComponentsExtension> {
                configurePrintApksTask(this)
                disableUnnecessaryAndroidTests(target)
            }
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            configurations.configureEach {
                resolutionStrategy {
                    force(libs.findLibrary("junit4").get())
                    // Temporary workaround for https://issuetracker.google.com/174733673
                    force("org.objenesis:objenesis:2.6")
                }
            }
            dependencies {
                add("androidTestImplementation", kotlin("test"))
                add("testImplementation", kotlin("test"))
            }
        }
    }
}