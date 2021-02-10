plugins {
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":fpinkotlin-common"))
    api("io.kotlintest:kotlintest-runner-junit5:${Versions.kotlintestJunitVersion}")
    api("io.kotlintest:kotlintest-extensions:${Versions.kotlintestJunitVersion}")
    runtimeOnly("org.slf4j:slf4j-nop:${Versions.slf4jVersion}")
}