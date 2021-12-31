plugins {
    kotlin("jvm") version "1.6.10"
    id("dev.mrbergin.run-dependency-tests")
}

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
    includeTestsFrom("dev.mrbergin.rdt:module-with-tests")
}