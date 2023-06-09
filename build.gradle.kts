val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val exposed_version: String by project



plugins {
    kotlin("jvm") version "1.6.0"
    id("io.ktor.plugin") version "2.1.2"
    kotlin("plugin.serialization") version "1.6.0"
}

group = "ru.newtry"
version = "0.0.1"
application {
    mainClass.set("ru.newtry.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {

    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-cio-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")

    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")

    //implementation("io.ktor:ktor-server-netty:$ktor_version")

    implementation("org.postgresql:postgresql:42.3.1")

    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")


}