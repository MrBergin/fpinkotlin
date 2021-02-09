plugins {
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":fpinkotlin-common"))
    implementation("io.kotest:kotest-extensions-junit5extensions:${Versions.kotestVersion}")
    runtimeOnly("org.slf4j:slf4j-nop:${Versions.slf4JVersion}")
}