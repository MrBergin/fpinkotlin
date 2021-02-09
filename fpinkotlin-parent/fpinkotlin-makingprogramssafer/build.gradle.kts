import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

configureFpInKotlinProject()

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    freeCompilerArgs = listOf("-XXLanguage:+InlineClasses")
}