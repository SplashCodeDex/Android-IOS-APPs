apply(plugin = "jacoco")
apply(plugin = "io.github.takahirom.roborazzi")

// Ensure jacoco test reports are generated after tests
tasks.withType<Test> {
    finalizedBy(tasks.withType<JacocoReport>())
}

tasks.withType<JacocoReport> {
    dependsOn(tasks.withType<Test>())
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}
