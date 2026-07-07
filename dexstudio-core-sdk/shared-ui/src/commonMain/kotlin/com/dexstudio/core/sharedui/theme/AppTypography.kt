package com.dexstudio.core.sharedui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.em

// For now we rely on the system font which falls back to San Francisco on iOS and Roboto on Android.
val AppleFontFamily = FontFamily.Default

val AppTypography = Typography(
    // Display Hero: 56px, 600, -0.28px spacing
    displayLarge = TextStyle(
        fontFamily = AppleFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 56.sp,
        lineHeight = 60.sp, // ~1.07
        letterSpacing = (-0.28).sp
    ),
    // Section Heading: 40px, 600
    displayMedium = TextStyle(
        fontFamily = AppleFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 40.sp,
        lineHeight = 44.sp, // ~1.10
        letterSpacing = 0.sp
    ),
    // Tile Heading: 28px, 400
    displaySmall = TextStyle(
        fontFamily = AppleFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 32.sp, // ~1.14
        letterSpacing = 0.196.sp
    ),
    // Card Title: 21px, 700
    headlineMedium = TextStyle(
        fontFamily = AppleFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 21.sp,
        lineHeight = 25.sp, // ~1.19
        letterSpacing = 0.231.sp
    ),
    // Nav Heading: 34px, 600
    titleLarge = TextStyle(
        fontFamily = AppleFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 34.sp,
        lineHeight = 50.sp, // ~1.47
        letterSpacing = (-0.374).sp
    ),
    // Body: 17px, 400, -0.374px
    bodyLarge = TextStyle(
        fontFamily = AppleFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        lineHeight = 25.sp, // ~1.47
        letterSpacing = (-0.374).sp
    ),
    // Link / Caption: 14px, 400, -0.224px
    bodyMedium = TextStyle(
        fontFamily = AppleFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp, // ~1.43
        letterSpacing = (-0.224).sp
    ),
    // Micro: 12px, 400, -0.12px
    labelSmall = TextStyle(
        fontFamily = AppleFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp, // ~1.33
        letterSpacing = (-0.12).sp
    )
)
