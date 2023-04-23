group = "libs.client"
version = "1.0-SNAPSHOT"


@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.jvm)

    application
}
application.mainClass.set("client.Main")

repositories {
    mavenCentral()
}


dependencies {
    implementation(kotlin("test"))
    implementation(kotlin("stdlib-jdk8"))

    //Cucumber
    implementation(libs.bundles.cucumber)
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<Jar> {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
        attributes["Main-Class"] = "client.Main"
    }

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })

    destinationDirectory.set(file("$buildDir/output"))
}




