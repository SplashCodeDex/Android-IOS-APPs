package com.dexstudio.core.sharedui.util

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.dexstudio.core.sharedui.animation.AppAnimations
import com.dexstudio.core.sharedui.designsystem.theme.DeXStudioTheme

@Composable
fun Modifier.pressScale(
    onClick: () -> Unit
): Modifier {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1.0f,
        animationSpec = AppAnimations.pressScaleSpring,
        label = "PressScale"
    )

    return this
        .graphicsLayer {
            scaleX = scale
            scaleY = scale
        }
        .clickable(
            interactionSource = interactionSource,
            indication = null, // Custom indication removed
            onClick = onClick
        )
}

@Composable
fun Modifier.glassBg(): Modifier {
    return this.background(DeXStudioTheme.appColors.navGlass)
}

@Composable
fun Modifier.pillShape(): Modifier {
    return this.background(
        color = Color.Transparent, 
        shape = DeXStudioTheme.appShapes.pill
    )
}

@Composable
fun Modifier.cardShadow(): Modifier {
    // 3px 5px 30px 0px rgba(0,0,0,0.22)
    return this.shadow(
        elevation = 30.dp,
        shape = DeXStudioTheme.appShapes.standard,
        clip = false,
        ambientColor = Color(0x38000000), // 0.22
        spotColor = Color(0x38000000)
    )
}
