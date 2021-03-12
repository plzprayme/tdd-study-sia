plugins {
    kotlin("jvm") version "1.4.31"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("io.kotest:kotest-runner-junit5:4.3.2")
    testImplementation("io.kotest:kotest-assertions-core-jvm:4.3.2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
