package com.dexstudio.core.sharedui.designsystem.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dexstudio.core.sharedui.designsystem.theme.DeXStudioTheme
import com.dexstudio.core.sharedui.util.glassBg

data class NavItem(val label: String, val onClick: () -> Unit)

@Composable
fun GlassNavigation(
    title: String,
    modifier: Modifier = Modifier,
    logo: (@Composable () -> Unit)? = null,
    navItems: List<NavItem> = emptyList()
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = if (navItems.isEmpty()) Arrangement.Center else Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .glassBg()
            .padding(horizontal = 24.dp)
    ) {
        if (logo != null) {
            logo()
        } else {
            Text(
                text = title,
                style = DeXStudioTheme.textStyles.micro,
                color = DeXStudioTheme.appColors.onPrimaryAction
            )
        }
        
        if (navItems.isNotEmpty()) {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                navItems.forEach { item ->
                    // Simplified for demo - we can wrap in clickable properly later
                    Text(
                        text = item.label,
                        style = DeXStudioTheme.textStyles.micro,
                        color = DeXStudioTheme.appColors.onPrimaryAction
                    )
                }
            }
        }
    }
}
