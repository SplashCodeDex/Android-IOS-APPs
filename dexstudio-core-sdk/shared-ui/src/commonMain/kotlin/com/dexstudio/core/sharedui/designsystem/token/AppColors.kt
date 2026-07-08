package com.dexstudio.core.sharedui.designsystem.token

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// Raw Color Tokens (Private to prevent direct access without semantic meaning if desired, but public here for flexibility)
val PureBlack = Color(0xFF000000)
val LightGray = Color(0xFFF5F5F7)
val NearBlack = Color(0xFF1D1D1F)
val PureWhite = Color(0xFFFFFFFF)

// Interactive
val AppleBlue = Color(0xFF0071E3)
val LinkBlueLight = Color(0xFF0066CC)
val LinkBlueDark = Color(0xFF2997FF)

// Text Variants
val TextBlack80 = Color(0xCC000000) // rgba(0,0,0,0.8)
val TextBlack48 = Color(0x7A000000) // rgba(0,0,0,0.48)

// Dark Surfaces
val DarkSurface1 = Color(0xFF272729)
val DarkSurface2 = Color(0xFF262628)
val DarkSurface3 = Color(0xFF28282A)
val DarkSurface4 = Color(0xFF2A2A2D)
val DarkSurface5 = Color(0xFF242426)

// Controls
val ButtonActive = Color(0xFFEDEDF2)
val ButtonDefaultLight = Color(0xFFFAFAFC)
val OverlayScrim = Color(0xA3D2D2D7) // rgba(210,210,215,0.64)
val ModalCloseHover = Color(0x52FFFFFF) // rgba(255,255,255,0.32)

// Nav Glass
val NavGlassBg = Color(0xCC000000) // rgba(0,0,0,0.8)

data class AppColorScheme(
    val primaryAction: Color,
    val onPrimaryAction: Color,
    val secondaryAction: Color,
    
    val background: Color,
    val onBackground: Color,
    
    val surfaceDefault: Color,
    val surfaceElevated1: Color,
    val surfaceElevated2: Color,
    val surfaceElevated3: Color,
    val surfaceElevated4: Color,
    val surfaceElevated5: Color,
    val onSurface: Color,
    
    val textPrimary: Color,
    val textSecondary: Color,
    val textTertiary: Color,
    val textDisabled: Color,
    
    val link: Color,
    val linkOnDark: Color,
    
    val navGlass: Color,
    val overlay: Color,
    val focusRing: Color,
    
    val error: Color,
    val onError: Color
)

val LightAppColorScheme = AppColorScheme(
    primaryAction = AppleBlue,
    onPrimaryAction = PureWhite,
    secondaryAction = ButtonDefaultLight,
    
    background = LightGray,
    onBackground = NearBlack,
    
    surfaceDefault = PureWhite,
    surfaceElevated1 = PureWhite,
    surfaceElevated2 = PureWhite,
    surfaceElevated3 = PureWhite,
    surfaceElevated4 = PureWhite,
    surfaceElevated5 = PureWhite,
    onSurface = NearBlack,
    
    textPrimary = NearBlack,
    textSecondary = TextBlack80,
    textTertiary = TextBlack48,
    textDisabled = TextBlack48,
    
    link = LinkBlueLight,
    linkOnDark = LinkBlueDark,
    
    navGlass = NavGlassBg,
    overlay = OverlayScrim,
    focusRing = AppleBlue,
    
    error = Color(0xFFFF3B30),
    onError = PureWhite
)

val DarkAppColorScheme = AppColorScheme(
    primaryAction = AppleBlue,
    onPrimaryAction = PureWhite,
    secondaryAction = NearBlack,
    
    background = PureBlack,
    onBackground = PureWhite,
    
    surfaceDefault = DarkSurface1,
    surfaceElevated1 = DarkSurface1,
    surfaceElevated2 = DarkSurface2,
    surfaceElevated3 = DarkSurface3,
    surfaceElevated4 = DarkSurface4,
    surfaceElevated5 = DarkSurface5,
    onSurface = PureWhite,
    
    textPrimary = PureWhite,
    textSecondary = Color(0xCCFFFFFF),
    textTertiary = Color(0x7AFFFFFF),
    textDisabled = Color(0x7AFFFFFF),
    
    link = LinkBlueDark,
    linkOnDark = LinkBlueDark,
    
    navGlass = NavGlassBg,
    overlay = OverlayScrim,
    focusRing = AppleBlue,
    
    error = Color(0xFFFF453A),
    onError = PureWhite
)

val LocalAppColorScheme = staticCompositionLocalOf { LightAppColorScheme }
