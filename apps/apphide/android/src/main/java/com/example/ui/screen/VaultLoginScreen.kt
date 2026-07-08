package com.example.ui.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dexstudio.core.sharedui.designsystem.theme.DeXStudioTheme
import com.dexstudio.core.sharedui.designsystem.token.AppSpacing
import com.dexstudio.core.sharedui.util.pressScale

@Composable
fun VaultLoginScreen(
    onLoginSuccess: () -> Unit
) {
    var pin by remember { mutableStateOf("") }
    val maxPinLength = 6

    // Dummy validation for demo purposes
    LaunchedEffect(pin) {
        if (pin.length == maxPinLength) {
            if (pin == "123456") {
                onLoginSuccess()
            } else {
                // Clear on failure (with slight delay for UX)
                kotlinx.coroutines.delay(300)
                pin = ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black) // Pure black for Vault feel
            .padding(vertical = 48.dp, horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Top Section: Icon & Instructions
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 64.dp)
        ) {
            // Placeholder for a sleek lock icon
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(Color(0xFF1C1C1E), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "🔒", style = DeXStudioTheme.textStyles.tileHeading)
            }
            
            Spacer(modifier = Modifier.height(AppSpacing.l))
            
            Text(
                text = "Enter PIN",
                style = DeXStudioTheme.textStyles.sectionHeading,
                color = Color.White
            )
            
            Spacer(modifier = Modifier.height(AppSpacing.xl))
            
            PinDotsIndicator(
                pinLength = pin.length,
                maxLength = maxPinLength
            )
        }

        // Bottom Section: Numpad
        CustomNumpad(
            onDigitClick = { digit ->
                if (pin.length < maxPinLength) {
                    pin += digit
                }
            },
            onBackspaceClick = {
                if (pin.isNotEmpty()) {
                    pin = pin.dropLast(1)
                }
            },
            modifier = Modifier.padding(bottom = 32.dp)
        )
    }
}

@Composable
fun PinDotsIndicator(
    pinLength: Int,
    maxLength: Int,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        for (i in 0 until maxLength) {
            val isFilled = i < pinLength
            val scale by animateFloatAsState(
                targetValue = if (isFilled) 1.2f else 1.0f,
                animationSpec = tween(150),
                label = "dotScale"
            )
            
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .scale(scale)
                    .background(
                        color = if (isFilled) Color.White else Color(0xFF333333),
                        shape = CircleShape
                    )
            )
        }
    }
}

@Composable
fun CustomNumpad(
    onDigitClick: (String) -> Unit,
    onBackspaceClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val keys = listOf(
        listOf("1", "2", "3"),
        listOf("4", "5", "6"),
        listOf("7", "8", "9"),
        listOf("", "0", "DEL")
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        keys.forEach { row ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f))
                row.forEach { key ->
                    if (key.isEmpty()) {
                        Box(modifier = Modifier.size(72.dp))
                    } else if (key == "DEL") {
                        Box(
                            modifier = Modifier
                                .size(72.dp)
                                .pressScale(onClick = onBackspaceClick),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "⌫",
                                style = DeXStudioTheme.textStyles.tileHeading,
                                color = Color(0xFF8E8E93)
                            )
                        }
                    } else {
                        Box(
                            modifier = Modifier
                                .size(72.dp)
                                .background(Color(0xFF1C1C1E), CircleShape)
                                .pressScale(onClick = { onDigitClick(key) }),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = key,
                                style = DeXStudioTheme.textStyles.displayHero,
                                color = Color.White,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}
