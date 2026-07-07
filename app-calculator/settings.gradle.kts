rootProject.name = "app-calculator"
include(":app")

val useLocalCore = true // Simulate local dev environment
if (useLocalCore) {
    includeBuild("../dexstudio-core-sdk") {
        dependencySubstitution {
            substitute(module("com.dexstudio.core:shared-ui")).using(project(":shared-ui"))
            substitute(module("com.dexstudio.core:shared-data")).using(project(":shared-data"))
        }
    }
}
