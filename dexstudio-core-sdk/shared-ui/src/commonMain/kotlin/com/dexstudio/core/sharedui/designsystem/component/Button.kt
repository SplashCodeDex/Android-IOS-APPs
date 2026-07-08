package com.dexstudio.core.sharedui.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dexstudio.core.sharedui.designsystem.theme.DeXStudioTheme
import com.dexstudio.core.sharedui.designsystem.token.AppSpacing
import com.dexstudio.core.sharedui.util.pillShape
import com.dexstudio.core.sharedui.util.pressScale

@Composable
fun PrimaryCTA(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = DeXStudioTheme.appColors.primaryAction,
            contentColor = DeXStudioTheme.appColors.onPrimaryAction
        ),
        shape = DeXStudioTheme.appShapes.standard,
        contentPadding = PaddingValues(horizontal = AppSpacing.sp15, vertical = AppSpacing.sp8),
        modifier = modifier.pressScale(onClick = onClick)
    ) {
        Text(
            text = text,
            style = DeXStudioTheme.textStyles.body,
            color = DeXStudioTheme.appColors.onPrimaryAction
        )
    }
}

@Composable
fun DarkCTA(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = DeXStudioTheme.appColors.secondaryAction,
            contentColor = DeXStudioTheme.appColors.onPrimaryAction
        ),
        shape = DeXStudioTheme.appShapes.standard,
        contentPadding = PaddingValues(horizontal = AppSpacing.sp15, vertical = AppSpacing.sp8),
        modifier = modifier.pressScale(onClick = onClick)
    ) {
        Text(
            text = text,
            style = DeXStudioTheme.textStyles.body,
            color = DeXStudioTheme.appColors.onPrimaryAction
        )
    }
}

@Composable
fun PillLink(
    text: String,
    isDarkBg: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val linkColor = if (isDarkBg) DeXStudioTheme.appColors.linkOnDark else DeXStudioTheme.appColors.link

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .pressScale(onClick = onClick)
            .padding(horizontal = AppSpacing.sp14, vertical = AppSpacing.sp8)
            .pillShape()
            .border(1.dp, linkColor, DeXStudioTheme.appShapes.pill)
            .padding(horizontal = AppSpacing.sp14, vertical = AppSpacing.sp8)
    ) {
        Text(
            text = "$text >", // Emulated chevron
            style = DeXStudioTheme.textStyles.link,
            color = linkColor
        )
    }
}

@Composable
fun FilterButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .pressScale(onClick = onClick)
            .background(DeXStudioTheme.appColors.secondaryAction, DeXStudioTheme.appShapes.comfortable)
            .border(3.dp, Color(0x0A000000), DeXStudioTheme.appShapes.comfortable)
            .padding(horizontal = AppSpacing.sp14, vertical = 0.dp)
    ) {
        Text(
            text = text,
            style = DeXStudioTheme.textStyles.body,
            color = DeXStudioTheme.appColors.textSecondary
        )
    }
}

@Composable
fun MediaControlButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .pressScale(onClick = onClick)
            .background(DeXStudioTheme.appColors.overlay, DeXStudioTheme.appShapes.circle)
            .padding(AppSpacing.sp10)
    ) {
        Text(
            text = text,
            style = DeXStudioTheme.textStyles.body,
            color = DeXStudioTheme.appColors.textTertiary
        )
    }
}
