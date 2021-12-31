plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    id("maven-publish")
    id("com.gradle.plugin-publish") version "0.16.0"
}

group = "dev.mrbergin"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(8))
    }
}

gradlePlugin {
    plugins {
        create("RunDependencyTests") {
            id = "dev.mrbergin.run-dependency-tests"
            displayName = "Run Tests From Dependencies"
            description =
                "A Plugin that allows you to declare dependencies against a test task and have that task run them"
            implementationClass = "dev.mrbergin.rdt.RunDependencyTestsPlugin"
        }
    }
}
