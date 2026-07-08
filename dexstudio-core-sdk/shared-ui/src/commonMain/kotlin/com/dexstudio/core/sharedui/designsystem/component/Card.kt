package com.dexstudio.core.sharedui.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dexstudio.core.sharedui.designsystem.theme.DeXStudioTheme
import com.dexstudio.core.sharedui.designsystem.token.AppSpacing
import com.dexstudio.core.sharedui.util.cardShadow

@Composable
fun ProductCard(
    image: @Composable () -> Unit,
    title: String,
    description: String,
    actions: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    isDarkBg: Boolean = false
) {
    val bgColor = if (isDarkBg) DeXStudioTheme.appColors.surfaceDefault else DeXStudioTheme.appColors.background
    
    Column(
        modifier = modifier
            .cardShadow()
            .background(bgColor, DeXStudioTheme.appShapes.standard)
            .padding(AppSpacing.l)
    ) {
        Box(modifier = Modifier.fillMaxWidth().weight(1f)) {
            image()
        }
        Spacer(modifier = Modifier.height(AppSpacing.m))
        Text(
            text = title,
            style = DeXStudioTheme.textStyles.cardTitle,
            color = DeXStudioTheme.appColors.textPrimary
        )
        Spacer(modifier = Modifier.height(AppSpacing.xs))
        Text(
            text = description,
            style = DeXStudioTheme.textStyles.caption,
            color = DeXStudioTheme.appColors.textSecondary
        )
        Spacer(modifier = Modifier.height(AppSpacing.m))
        actions()
    }
}

@Composable
fun ProductGridTile(
    image: @Composable () -> Unit,
    title: String,
    description: String,
    actions: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    isDarkBg: Boolean = false
) {
    val bgColor = if (isDarkBg) DeXStudioTheme.appColors.surfaceDefault else DeXStudioTheme.appColors.background
    
    Column(
        modifier = modifier
            .aspectRatio(1f)
            .background(bgColor, DeXStudioTheme.appShapes.standard)
            .padding(AppSpacing.m)
    ) {
        Box(modifier = Modifier.fillMaxWidth().weight(0.6f)) {
            image()
        }
        Spacer(modifier = Modifier.height(AppSpacing.s))
        Text(
            text = title,
            style = DeXStudioTheme.textStyles.tileHeading,
            color = DeXStudioTheme.appColors.textPrimary
        )
        Spacer(modifier = Modifier.height(AppSpacing.xs))
        Text(
            text = description,
            style = DeXStudioTheme.textStyles.caption,
            color = DeXStudioTheme.appColors.textSecondary
        )
        Spacer(modifier = Modifier.height(AppSpacing.s))
        actions()
    }
}
