import com.google.protobuf.gradle.*

val coroutinesVersion = "1.1.1"
val jacksonVersion = "2.9.7"
val krotoPlusVersion = "0.3.1-SNAPSHOT"
val kotlinVersion = "1.3.21"
val protocVersion = "3.7.0"
val grpcVersion = "1.18.0"

plugins {
    idea
    java
    id("io.kotlintest") version "1.0.2"
    id("com.google.protobuf") version "0.8.8"
}

repositories {
    maven { url = uri("https://dl.bintray.com/marcoferrer/kroto-plus/") }
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))

    implementation("com.google.protobuf:protoc-gen-javalite:3.0.0")
    implementation("com.github.marcoferrer.krotoplus:kroto-plus-gradle-plugin:+")
    implementation("com.github.marcoferrer.krotoplus:protoc-gen-kroto-plus:+")
    implementation("io.grpc:grpc-protobuf-lite:$grpcVersion")
    implementation("io.grpc:grpc-stub:$grpcVersion")
    implementation("io.grpc:grpc-okhttp:$grpcVersion")
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion")
    protobuf("com.google.api.grpc:proto-google-common-protos:1.12.0")

    implementation("com.google.zxing:core:3.3.3")
    testImplementation("junit:junit:4.12")
}



protobuf {
    generatedFilesBaseDir = "$projectDir/src"

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
        id("kroto") {
            artifact = "com.github.marcoferrer.krotoplus:protoc-gen-kroto-plus:0.1.3:jvm8@jar"
        }
//        id("kroto-coroutines") {
//            artifact = "com.github.marcoferrer.krotoplus:protoc-gen-grpc-coroutines:$krotoPlusVersion:jvm8@jar"
//        }
    }

    generateProtoTasks {
        val krotoConfig = file("krotoPlusConfig.asciipb")
        all().forEach {
            it.builtins {
                remove("java")
            }
            it.plugins {
                create("javalite") {
                    outputSubDir = "java"
                }
//                create("kroto-coroutines")
                create("grpc") {
                    option("lite")
                }
                create("kroto") {
                    outputSubDir = "java"
                    option("ConfigPath=krotoPlusConfig.asciipb")
                }
            }
        }
    }
}
