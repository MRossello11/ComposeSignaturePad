
buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")

        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
        classpath("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.23.0")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.github.ben-manes.versions") version "0.47.0"
    id("io.gitlab.arturbosch.detekt") version "1.22.0"
    id("io.github.gradle-nexus.publish-plugin") version "1.3.0"
    id("org.jetbrains.kotlinx.binary-compatibility-validator") version "0.13.2"
}