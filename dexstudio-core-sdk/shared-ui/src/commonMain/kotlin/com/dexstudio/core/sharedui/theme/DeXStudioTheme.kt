package com.dexstudio.core.sharedui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = AppleBlue,
    onPrimary = PureWhite,
    background = LightGray,
    onBackground = NearBlack,
    surface = PureWhite,
    onSurface = NearBlack
)

private val DarkColors = darkColorScheme(
    primary = AppleBlue,
    onPrimary = PureWhite,
    background = PureBlack,
    onBackground = PureWhite,
    surface = DarkSurface1,
    onSurface = PureWhite
)

@Composable
fun DeXStudioTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (useDarkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        content = content
    )
}
