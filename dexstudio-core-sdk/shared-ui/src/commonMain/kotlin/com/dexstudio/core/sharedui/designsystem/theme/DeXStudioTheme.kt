package com.dexstudio.core.sharedui.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.dexstudio.core.sharedui.designsystem.token.*

@Composable
fun DeXStudioTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (useDarkTheme) DarkAppColorScheme else LightAppColorScheme
    val textStyles = getAppTextStyles()
    val shapes = AppShapes()

    val m3Colors = if (useDarkTheme) {
        darkColorScheme(
            primary = colorScheme.primaryAction,
            onPrimary = colorScheme.onPrimaryAction,
            secondary = colorScheme.secondaryAction,
            onSecondary = colorScheme.textPrimary,
            tertiary = colorScheme.secondaryAction,
            onTertiary = colorScheme.textPrimary,
            background = colorScheme.background,
            onBackground = colorScheme.onBackground,
            surface = colorScheme.surfaceDefault,
            onSurface = colorScheme.onSurface,
            surfaceVariant = colorScheme.surfaceElevated1,
            onSurfaceVariant = colorScheme.textSecondary,
            error = colorScheme.error,
            onError = colorScheme.onError,
            outline = colorScheme.textTertiary
        )
    } else {
        lightColorScheme(
            primary = colorScheme.primaryAction,
            onPrimary = colorScheme.onPrimaryAction,
            secondary = colorScheme.secondaryAction,
            onSecondary = colorScheme.textPrimary,
            tertiary = colorScheme.secondaryAction,
            onTertiary = colorScheme.textPrimary,
            background = colorScheme.background,
            onBackground = colorScheme.onBackground,
            surface = colorScheme.surfaceDefault,
            onSurface = colorScheme.onSurface,
            surfaceVariant = colorScheme.surfaceElevated1,
            onSurfaceVariant = colorScheme.textSecondary,
            error = colorScheme.error,
            onError = colorScheme.onError,
            outline = colorScheme.textTertiary
        )
    }

    CompositionLocalProvider(
        LocalAppColorScheme provides colorScheme,
        LocalAppTextStyles provides textStyles,
        LocalAppShapes provides shapes
    ) {
        MaterialTheme(
            colorScheme = m3Colors,
            typography = getM3Typography(textStyles),
            content = content
        )
    }
}

object DeXStudioTheme {
    val appColors: AppColorScheme
        @Composable
        get() = LocalAppColorScheme.current

    val textStyles: AppTextStyles
        @Composable
        get() = LocalAppTextStyles.current

    val appShapes: AppShapes
        @Composable
        get() = LocalAppShapes.current
}
