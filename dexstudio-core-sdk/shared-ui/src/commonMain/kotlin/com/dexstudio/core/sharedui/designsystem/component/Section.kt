package com.dexstudio.core.sharedui.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.dexstudio.core.sharedui.designsystem.theme.DeXStudioTheme
import com.dexstudio.core.sharedui.designsystem.token.AppSpacing

@Composable
fun HeroSection(
    title: String,
    subtitle: String,
    isDark: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    val bgColor = if (isDark) DeXStudioTheme.appColors.background else DeXStudioTheme.appColors.background
    val textColor = if (isDark) DeXStudioTheme.appColors.textPrimary else DeXStudioTheme.appColors.textPrimary
    
    // Quick fix for the "isDark" parameter which usually meant Black vs Gray.
    // Assuming DarkAppColorScheme or LightAppColorScheme handles this generally,
    // but we can manually override for visual rhythm.
    val actualBgColor = if (isDark) com.dexstudio.core.sharedui.designsystem.token.PureBlack else com.dexstudio.core.sharedui.designsystem.token.LightGray
    val actualTextColor = if (isDark) com.dexstudio.core.sharedui.designsystem.token.PureWhite else com.dexstudio.core.sharedui.designsystem.token.NearBlack

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .background(actualBgColor)
            .padding(vertical = AppSpacing.hero, horizontal = AppSpacing.l)
    ) {
        Text(
            text = title,
            style = DeXStudioTheme.textStyles.displayHero,
            color = actualTextColor,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(AppSpacing.s))
        Text(
            text = subtitle,
            style = DeXStudioTheme.textStyles.tileHeading,
            color = actualTextColor,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(AppSpacing.l))
        content()
    }
}
