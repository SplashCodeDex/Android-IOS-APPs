package com.dexstudio.core.sharedui.designsystem.token

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

/**
 * Derived from DESIGN.md §5
 */
data class AppShapes(
    val micro: RoundedCornerShape = RoundedCornerShape(5.dp),
    val standard: RoundedCornerShape = RoundedCornerShape(8.dp),
    val comfortable: RoundedCornerShape = RoundedCornerShape(11.dp),
    val large: RoundedCornerShape = RoundedCornerShape(12.dp),
    val pill: RoundedCornerShape = RoundedCornerShape(980.dp),
    val circle: RoundedCornerShape = RoundedCornerShape(50)
)

val LocalAppShapes = staticCompositionLocalOf { AppShapes() }
