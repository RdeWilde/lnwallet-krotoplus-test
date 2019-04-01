import com.google.protobuf.gradle.GenerateProtoTask
import com.google.protobuf.gradle.*

val coroutinesVersion = "1.1.1"
val krotoPlusVersion = "0.2.2-RC3"
val kotlinVersion = "1.3.21"
val protocVersion = "3.7.0"
val grpcVersion = "1.18.0"

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    id("com.google.protobuf") version "0.8.8"
}

repositories {
    maven { url = uri("https://dl.bintray.com/marcoferrer/kroto-plus/") }
}

android {
    // TODO
    lintOptions {
        isAbortOnError = false
    }

    compileSdkVersion(28)
    defaultConfig {
        applicationId = "dev.sillerud.lnwallet"
        minSdkVersion(19)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    packagingOptions {
        exclude("META-INF/INDEX.LIST")
        exclude("META-INF/io.netty.versions.properties")
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.7.0"
    }

    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion"
        }
        id("javalite") {
            artifact = "com.google.protobuf:protoc-gen-javalite:3.0.0"
        }
        /*id("kroto") {
            artifact = "com.github.marcoferrer.krotoplus:protoc-gen-kroto-plus:$krotoPlusVersion:jvm8@jar"
        }*/
        id("kroto-coroutines") {
            artifact = "com.github.marcoferrer.krotoplus:protoc-gen-grpc-coroutines:$krotoPlusVersion:jvm8@jar"
        }
    }

    generateProtoTasks {
        val krotoConfig = file("krotoPlusConfig.json")
        all().forEach {
            it.plugins {
                create("javalite")
                create("kroto-coroutines")
                create("grpc") {
                    option("lite")
                }
                /*create("kroto") {
                    option("ConfigPath=krotoPlusConfig.asciipb")
                }*/
            }
        }
    }
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))

    implementation("com.google.protobuf:protoc-gen-javalite:3.0.0")
    implementation("io.grpc:grpc-protobuf-lite:$grpcVersion")
    implementation("io.grpc:grpc-stub:$grpcVersion")
    implementation("io.grpc:grpc-okhttp:$grpcVersion")
    implementation("javax.annotation:javax.annotation-api:1.3.2")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion")
    implementation("com.android.support:appcompat-v7:28.0.0")
    implementation("com.android.support:preference-v7:28.0.0")

    implementation("com.android.support.constraint:constraint-layout:1.1.3")
    implementation("com.android.support:design:28.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("com.github.marcoferrer.krotoplus:kroto-plus-coroutines:$krotoPlusVersion")
    implementation("com.android.support:support-v4:28.0.0")

    implementation("com.google.zxing:core:3.3.3")
    implementation("com.journeyapps:zxing-android-embedded:3.6.0")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")
}
