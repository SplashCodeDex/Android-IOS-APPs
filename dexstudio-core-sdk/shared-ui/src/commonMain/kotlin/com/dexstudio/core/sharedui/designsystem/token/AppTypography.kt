package com.dexstudio.core.sharedui.designsystem.token

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import apphide.dexstudio_core_sdk.shared_ui.generated.resources.Res
import apphide.dexstudio_core_sdk.shared_ui.generated.resources.*
import org.jetbrains.compose.resources.Font

@Composable
fun getInterFontFamily() = FontFamily(
    Font(Res.font.inter_regular, FontWeight.Normal),
    Font(Res.font.inter_semibold, FontWeight.SemiBold),
    Font(Res.font.inter_bold, FontWeight.Bold)
)

data class AppTextStyles(
    val displayHero: TextStyle,
    val sectionHeading: TextStyle,
    val tileHeading: TextStyle,
    val cardTitle: TextStyle,
    val subHeading: TextStyle,
    val navHeading: TextStyle,
    val subNav: TextStyle,
    val body: TextStyle,
    val bodyEmphasis: TextStyle,
    val buttonLarge: TextStyle,
    val button: TextStyle,
    val link: TextStyle,
    val caption: TextStyle,
    val captionBold: TextStyle,
    val micro: TextStyle,
    val microBold: TextStyle,
    val nano: TextStyle
)

@Composable
fun getAppTextStyles(): AppTextStyles {
    val inter = getInterFontFamily()
    return AppTextStyles(
        // Display Hero: 56px, 600, -0.28px
        displayHero = TextStyle(fontFamily = inter, fontWeight = FontWeight.SemiBold, fontSize = 56.sp, lineHeight = 60.sp, letterSpacing = (-0.28).sp),
        // Section Heading: 40px, 600, 0px
        sectionHeading = TextStyle(fontFamily = inter, fontWeight = FontWeight.SemiBold, fontSize = 40.sp, lineHeight = 44.sp, letterSpacing = 0.sp),
        // Tile Heading: 28px, 400, 0.196px
        tileHeading = TextStyle(fontFamily = inter, fontWeight = FontWeight.Normal, fontSize = 28.sp, lineHeight = 32.sp, letterSpacing = 0.196.sp),
        // Card Title: 21px, 700, 0.231px
        cardTitle = TextStyle(fontFamily = inter, fontWeight = FontWeight.Bold, fontSize = 21.sp, lineHeight = 25.sp, letterSpacing = 0.231.sp),
        // Sub-heading: 21px, 400, 0.231px
        subHeading = TextStyle(fontFamily = inter, fontWeight = FontWeight.Normal, fontSize = 21.sp, lineHeight = 25.sp, letterSpacing = 0.231.sp),
        // Nav Heading: 34px, 600, -0.374px
        navHeading = TextStyle(fontFamily = inter, fontWeight = FontWeight.SemiBold, fontSize = 34.sp, lineHeight = 50.sp, letterSpacing = (-0.374).sp),
        // Sub-nav: 24px, 300 (falling back to normal since we don't have 300), 0px
        subNav = TextStyle(fontFamily = inter, fontWeight = FontWeight.Normal, fontSize = 24.sp, lineHeight = 36.sp, letterSpacing = 0.sp),
        // Body: 17px, 400, -0.374px
        body = TextStyle(fontFamily = inter, fontWeight = FontWeight.Normal, fontSize = 17.sp, lineHeight = 25.sp, letterSpacing = (-0.374).sp),
        // Body Emphasis: 17px, 600, -0.374px
        bodyEmphasis = TextStyle(fontFamily = inter, fontWeight = FontWeight.SemiBold, fontSize = 17.sp, lineHeight = 21.sp, letterSpacing = (-0.374).sp),
        // Button Large: 18px, 300 (falling back to normal), 0px
        buttonLarge = TextStyle(fontFamily = inter, fontWeight = FontWeight.Normal, fontSize = 18.sp, lineHeight = 18.sp, letterSpacing = 0.sp),
        // Button: 17px, 400, 0px
        button = TextStyle(fontFamily = inter, fontWeight = FontWeight.Normal, fontSize = 17.sp, lineHeight = 41.sp, letterSpacing = 0.sp),
        // Link: 14px, 400, -0.224px
        link = TextStyle(fontFamily = inter, fontWeight = FontWeight.Normal, fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = (-0.224).sp),
        // Caption: 14px, 400, -0.224px
        caption = TextStyle(fontFamily = inter, fontWeight = FontWeight.Normal, fontSize = 14.sp, lineHeight = 18.sp, letterSpacing = (-0.224).sp),
        // Caption Bold: 14px, 600, -0.224px
        captionBold = TextStyle(fontFamily = inter, fontWeight = FontWeight.SemiBold, fontSize = 14.sp, lineHeight = 18.sp, letterSpacing = (-0.224).sp),
        // Micro: 12px, 400, -0.12px
        micro = TextStyle(fontFamily = inter, fontWeight = FontWeight.Normal, fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = (-0.12).sp),
        // Micro Bold: 12px, 600, -0.12px
        microBold = TextStyle(fontFamily = inter, fontWeight = FontWeight.SemiBold, fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = (-0.12).sp),
        // Nano: 10px, 400, -0.08px
        nano = TextStyle(fontFamily = inter, fontWeight = FontWeight.Normal, fontSize = 10.sp, lineHeight = 15.sp, letterSpacing = (-0.08).sp)
    )
}

val LocalAppTextStyles = staticCompositionLocalOf<AppTextStyles> {
    error("No AppTextStyles provided")
}

@Composable
fun getM3Typography(appTextStyles: AppTextStyles) = Typography(
    displayLarge = appTextStyles.displayHero,
    displayMedium = appTextStyles.sectionHeading,
    displaySmall = appTextStyles.tileHeading,
    headlineMedium = appTextStyles.cardTitle,
    titleLarge = appTextStyles.navHeading,
    bodyLarge = appTextStyles.body,
    bodyMedium = appTextStyles.link,
    labelSmall = appTextStyles.micro
)
