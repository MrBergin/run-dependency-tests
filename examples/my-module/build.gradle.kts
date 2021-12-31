plugins {
    kotlin("jvm") version "1.6.10"
    id("dev.mrbergin.run-dependency-tests")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
    includeTestsFrom("dev.mrbergin.rdt.examples:arch-tests")
}