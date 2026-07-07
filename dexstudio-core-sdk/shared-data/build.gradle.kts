plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.google.devtools.ksp)
}

kotlin {
    jvm()
    android {
        namespace = "com.dexstudio.core.shareddata"
        compileSdk = 35
        minSdk = 24
        
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared_data"
            isStatic = true
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.androidx.room3.runtime)
            implementation(libs.koin.core)
        }
        
        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
        }
        
        val jvmMain by getting {
            dependencies {
                implementation(libs.ktor.client.okhttp)
                implementation("androidx.sqlite:sqlite-bundled:2.5.0-alpha05")
            }
        }
        
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
    }
}


dependencies {
    ksp(libs.androidx.room3.compiler)
}
