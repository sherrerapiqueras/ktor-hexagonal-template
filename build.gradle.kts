val ktorVersion by extra { "2.3.11" }
val kotlinVersion by extra { "2.0.0" }
val kotlinxDatetimeVersion by extra { "0.5.0" }
val mongoDriverVersion by extra { "5.1" }
val logbackVersion by extra { "1.5.6" }
val logbackJsonVersion by extra { "0.1.5" }

plugins {
    kotlin("jvm") version "2.0.0"
    id("io.ktor.plugin") version "2.3.11"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.0"
}

group = "com.elpan"
version = "0.0.1"

application {
    mainClass.set("com.elpan.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
    implementation("io.ktor:ktor-server-call-logging-jvm")
    implementation("io.ktor:ktor-server-swagger-jvm")
    implementation("io.ktor:ktor-server-host-common-jvm")
    implementation("io.ktor:ktor-server-status-pages-jvm")
    implementation("io.ktor:ktor-server-auth-jvm")
    implementation("io.ktor:ktor-server-auth-jwt-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:$kotlinxDatetimeVersion")

    implementation("org.mongodb:mongodb-driver-kotlin-coroutine:$mongoDriverVersion")
    implementation("org.mongodb:bson-kotlinx:$mongoDriverVersion")

    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("ch.qos.logback.contrib:logback-json-classic:$logbackJsonVersion")

    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}
