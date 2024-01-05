// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.3"  apply false
    id("org.jetbrains.kotlin.android") version "1.9.21"   apply false
    id("com.android.library") version "8.1.3"  apply false
    id("com.google.dagger.hilt.android") version "2.49"   apply false
    id("org.jetbrains.kotlin.jvm") version "2.0.0-Beta1"
}
buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0-Beta1")
    }
}

apply(plugin = "org.jetbrains.kotlin.jvm")