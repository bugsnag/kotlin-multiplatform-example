plugins {
    id("application")
    id("java")
    id("kotlin")
}

application {
    mainClassName = "com.bugsnag.example.kotlinmp.Main"
}

dependencies {
    // kotlin jdk
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}")
    implementation(project(":common"))
    implementation("com.bugsnag:bugsnag:${Versions.bugsnagJvm}")
}
