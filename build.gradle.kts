// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        val kotlinVersion = "1.3.21"
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        
    }
}

val wrapper = tasks.getByName<Wrapper>("wrapper") {
    gradleVersion = "5.5"
    distributionType = Wrapper.DistributionType.ALL
}