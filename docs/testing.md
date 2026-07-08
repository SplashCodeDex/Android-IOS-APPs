# Testing Strategy for DexStudio Apps

This document outlines the standard testing architecture and workflows for apps built within the DexStudio ecosystem, integrating Kotlin Multiplatform, Compose Multiplatform, and Android UI frameworks.

## 1. Unit Tests (Local)

Unit tests handle the business logic (ViewModels, Repositories, Use Cases).

**Frameworks:**
- **JUnit4**: Standard execution.
- **Mockk** (Optional/As Needed): For mocking complex external dependencies not easily substituted with fakes.
- **Koin Test**: For testing dependency injection configurations and overriding dependencies with fakes.

**Commands:**
```bash
# Run unit tests across all modules
./gradlew testDebugUnitTest
```

## 2. Screenshot Tests (Roborazzi)

Roborazzi is the **exclusive, mandatory** screenshot testing framework for all DexStudio apps. Dropshots and Google's built-in preview tests are strictly forbidden to ensure a unified, lightning-fast testing pipeline. These tests use Robolectric to render Compose components or fragments without needing an emulator.

**Location:** `src/test/java/...`
**Usage:** Create tests annotated with `@RunWith(RobolectricTestRunner::class)` and `@GraphicsMode(GraphicsMode.Mode.NATIVE)`.

**Commands:**
```bash
# Record baseline screenshots (Run this when introducing a new UI component or modifying an existing one)
./gradlew recordRoborazziDebug

# Verify screenshots (Run this in CI or before committing to check for visual regressions)
./gradlew verifyRoborazziDebug
```



## 4. UI Behavior and End-to-End Tests

Espresso and Compose UI Testing APIs are used for verifying user interactions, state restorations, and navigation paths.

**Commands:**
```bash
# Run all instrumented tests on connected devices
./gradlew connectedAndroidTest
```

## 5. Code Coverage (Jacoco)

Jacoco is integrated to provide test coverage metrics. It generates HTML/XML reports that map the executed code against the overall source.

**Commands:**
```bash
# Generate the coverage report
./gradlew jacocoTestReport
```

## Writing Test Doubles (Fakes vs Mocks)

We strongly prefer **Fakes** (in-memory implementations of interfaces) over **Mocks**.
Use Koin's `module { single<MyRepo> { FakeMyRepo() } }` to swap out production data layers with fakes during both unit tests and UI tests, ensuring robust, predictable behavior without network flakiness.
