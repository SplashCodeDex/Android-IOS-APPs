package com.dexstudio.core.sharedui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dexstudio.core.sharedui.theme.*

@Composable
fun PrimaryCTA(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = AppleBlue,
            contentColor = PureWhite
        ),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 8.dp),
        modifier = modifier
    ) {
        Text(
            text = text,
            style = AppTypography.bodyLarge,
            color = PureWhite
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
    val linkColor = if (isDarkBg) LinkBlueDark else LinkBlueLight
    
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .background(Color.Transparent, RoundedCornerShape(980.dp))
    ) {
        Text(
            text = "$text >", // Simple chevron emulation
            style = AppTypography.bodyMedium,
            color = linkColor
        )
    }
}

@Composable
fun GlassNavigation(
    title: String,
    modifier: Modifier = Modifier
) {
    // Note: True backdrop-filter blur requires platform-specific RenderEffects.
    // For this generic KMP component, we use the translucent glass background.
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(NavGlassBg)
    ) {
        Text(
            text = title,
            style = AppTypography.labelSmall,
            color = PureWhite
        )
    }
}

@Composable
fun HeroSection(
    title: String,
    subtitle: String,
    isDark: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    val bgColor = if (isDark) PureBlack else LightGray
    val textColor = if (isDark) PureWhite else NearBlack
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .background(bgColor)
            .padding(vertical = 64.dp, horizontal = 24.dp)
    ) {
        Text(
            text = title,
            style = AppTypography.displayLarge,
            color = textColor,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = subtitle,
            style = AppTypography.displaySmall,
            color = textColor,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))
        content()
    }
}
