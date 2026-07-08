package com.example.apptwo.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.dexstudio.core.sharedui.designsystem.theme.DeXStudioTheme

enum class CalculatorButtonType {
    Normal,
    Action,
    Primary
}

@Composable
fun CalculatorButton(
    text: String,
    type: CalculatorButtonType,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isWide: Boolean = false
) {
    val backgroundColor = when (type) {
        CalculatorButtonType.Normal -> DeXStudioTheme.appColors.surfaceElevated4
        CalculatorButtonType.Action -> DeXStudioTheme.appColors.secondaryAction
        CalculatorButtonType.Primary -> DeXStudioTheme.appColors.primaryAction
    }
    
    val textColor = when (type) {
        CalculatorButtonType.Normal -> DeXStudioTheme.appColors.textPrimary
        CalculatorButtonType.Action -> DeXStudioTheme.appColors.onSurface
        CalculatorButtonType.Primary -> DeXStudioTheme.appColors.onPrimaryAction
    }

    val baseModifier = if (isWide) {
        modifier.aspectRatio(2f)
    } else {
        modifier.aspectRatio(1f)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = baseModifier
            .clip(DeXStudioTheme.appShapes.pill)
            .background(backgroundColor)
            .clickable(onClick = onClick)
    ) {
        Text(
            text = text,
            style = DeXStudioTheme.textStyles.sectionHeading,
            color = textColor
        )
    }
}
