import kotlinx.benchmark.gradle.JvmBenchmarkTarget

plugins {
    kotlin("plugin.allopen") version "2.0.20"
    kotlin("jvm") version "2.0.20"
    id("org.jetbrains.kotlinx.benchmark") version "0.4.12"
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.12")
//    implementation("org.openjdk.jmh:jmh-core:1.37")
}

benchmark {
    configurations {
        named("main") {
            iterationTime = 5
            iterationTimeUnit = "sec"

        }
    }
    targets {
        register("main") {
            this as JvmBenchmarkTarget
            jmhVersion = "1.37"
        }
    }
}

allOpen {
    annotation("org.openjdk.jmh.annotations.State")
}

