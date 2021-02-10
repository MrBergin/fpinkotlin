@file:Suppress("UnstableApiUsage")

import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.testing.Test
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.*

private fun Project.kotlinPlugin() {
    apply(plugin = "org.jetbrains.kotlin.jvm")
}

private fun Project.group() {
    group = "com.fpinkotlin"
}

private fun Project.version() {
    version = "1.0-SNAPSHOT"
}

private fun Project.javaConfig() {
    (extensions.getByName("java") as? JavaPluginExtension)?.apply {
        toolchain.languageVersion.set(JavaLanguageVersion.of(11))
        consistentResolution {
            useCompileClasspathVersions()
        }
    }
}


private fun Project.junitPlatform() {
    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

private fun Project.dependencies() {
    dependencies.apply {
        implementation(kotlin("stdlib-jdk8"))
        implementation(project(":fpinkotlin-common"))
        testImplementation(project(":fpinkotlin-common-test"))
    }
}

fun Project.configureFpInKotlinProject() {
    kotlinPlugin()
    group()
    version()
    javaConfig()
    dependencies()
    junitPlatform()
}

object Versions {
    const val jdomVersion = "2.0.6"
    const val slf4jVersion = "1.7.25"
    const val kotlintestJunitVersion = "3.4.2"
    const val kotlinCoroutinesVersion = "1.3.3"
}

fun DependencyHandler.implementation(library: Any) {
    add("implementation", library)
}

fun DependencyHandler.testImplementation(library: Any) {
    add("testImplementation", library)
}