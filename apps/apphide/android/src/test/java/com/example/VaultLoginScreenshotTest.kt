package com.example

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import com.example.ui.theme.MyApplicationTheme
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

import com.example.ui.screen.VaultLoginScreen
import com.dexstudio.core.sharedui.designsystem.theme.DeXStudioTheme

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(qualifiers = RobolectricDeviceQualifiers.Pixel8, sdk = [34])
class VaultLoginScreenshotTest {

  @get:Rule val composeTestRule = createComposeRule()

  @Test
  fun vault_login_screenshot() {
    composeTestRule.setContent { DeXStudioTheme { VaultLoginScreen(onLoginSuccess = {}) } }

    composeTestRule.onRoot().captureRoboImage(filePath = "src/test/screenshots/vault_login.png")
  }
}
