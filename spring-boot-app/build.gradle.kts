import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
        jcenter()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${Versions.springBoot}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("org.jetbrains.kotlin:kotlin-allopen:${Versions.kotlin}")
    }
}

plugins {
    id("kotlin")
    id("org.jetbrains.kotlin.plugin.spring") version Versions.kotlin
    id("org.springframework.boot") version Versions.springBoot
    id("io.spring.dependency-management") version Versions.depManagement
}

group = "com.bugsnag.example.kotlinmp"
version = "0.0.1-SNAPSHOT"

dependencies {
    api(project(":common"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.bugsnag:bugsnag-spring:${Versions.bugsnagJvm}")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}

tasks.withType(KotlinCompile::class.java).all {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.freeCompilerArgs =
        listOf(*kotlinOptions.freeCompilerArgs.toTypedArray(), "-Xjsr305=strict")
}
