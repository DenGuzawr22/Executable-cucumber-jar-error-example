import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
group = "test"
version = "1.0-SNAPSHOT"

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.jvm)
}

repositories {
    mavenCentral()
}


subprojects{
    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "16"
    }
}
