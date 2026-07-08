plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlin.compose)
}

sourceSets {
    main {
        kotlin.srcDir("src/jvmMain/kotlin")
    }
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(compose.material3)
    implementation(compose.ui)
    implementation(project(":dexstudio-core-sdk:shared-ui"))
    implementation(project(":dexstudio-core-sdk:shared-data"))
    implementation(libs.koin.core)
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg, org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi, org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb)
            packageName = "DeXStudioDesktop"
            packageVersion = "1.0.0"
        }
    }
}
