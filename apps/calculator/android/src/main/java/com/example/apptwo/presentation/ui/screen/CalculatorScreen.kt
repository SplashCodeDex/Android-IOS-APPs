package com.example.apptwo.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.apptwo.domain.calculator.CalculatorAction
import com.example.apptwo.domain.calculator.CalculatorOperation
import com.dexstudio.core.sharedui.designsystem.theme.DeXStudioTheme
import com.dexstudio.core.sharedui.designsystem.token.AppSpacing
import com.example.apptwo.presentation.ui.components.CalculatorButton
import com.example.apptwo.presentation.ui.components.CalculatorButtonType
import com.example.apptwo.presentation.ui.components.CalculatorDisplay
import com.example.apptwo.presentation.viewmodel.CalculatorViewModel

@Composable
fun CalculatorScreen(
    viewModel: CalculatorViewModel,
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsState()
    
    val expression = buildString {
        append(state.number1)
        if (state.operation != null) {
            append(" ${state.operation?.symbol} ")
            append(state.number2)
        }
    }
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(DeXStudioTheme.appColors.background)
            .padding(AppSpacing.m),
        verticalArrangement = Arrangement.Bottom
    ) {
        CalculatorDisplay(
            expression = expression,
            result = if (state.operation == null) state.number1 else state.number2,
            modifier = Modifier.weight(1f)
        )
        
        Spacer(modifier = Modifier.height(AppSpacing.sp20))
        
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                CalculatorButton(text = "AC", type = CalculatorButtonType.Action, modifier = Modifier.weight(1f), onClick = { viewModel.onAction(CalculatorAction.Clear) })
                CalculatorButton(text = "DEL", type = CalculatorButtonType.Action, modifier = Modifier.weight(1f), onClick = { viewModel.onAction(CalculatorAction.Delete) })
                CalculatorButton(text = "÷", type = CalculatorButtonType.Primary, modifier = Modifier.weight(1f), onClick = { viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide)) })
            }
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                CalculatorButton(text = "7", type = CalculatorButtonType.Normal, modifier = Modifier.weight(1f), onClick = { viewModel.onAction(CalculatorAction.Number(7)) })
                CalculatorButton(text = "8", type = CalculatorButtonType.Normal, modifier = Modifier.weight(1f), onClick = { viewModel.onAction(CalculatorAction.Number(8)) })
                CalculatorButton(text = "9", type = CalculatorButtonType.Normal, modifier = Modifier.weight(1f), onClick = { viewModel.onAction(CalculatorAction.Number(9)) })
                CalculatorButton(text = "×", type = CalculatorButtonType.Primary, modifier = Modifier.weight(1f), onClick = { viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply)) })
            }
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                CalculatorButton(text = "4", type = CalculatorButtonType.Normal, modifier = Modifier.weight(1f), onClick = { viewModel.onAction(CalculatorAction.Number(4)) })
                CalculatorButton(text = "5", type = CalculatorButtonType.Normal, modifier = Modifier.weight(1f), onClick = { viewModel.onAction(CalculatorAction.Number(5)) })
                CalculatorButton(text = "6", type = CalculatorButtonType.Normal, modifier = Modifier.weight(1f), onClick = { viewModel.onAction(CalculatorAction.Number(6)) })
                CalculatorButton(text = "−", type = CalculatorButtonType.Primary, modifier = Modifier.weight(1f), onClick = { viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract)) })
            }
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                CalculatorButton(text = "1", type = CalculatorButtonType.Normal, modifier = Modifier.weight(1f), onClick = { viewModel.onAction(CalculatorAction.Number(1)) })
                CalculatorButton(text = "2", type = CalculatorButtonType.Normal, modifier = Modifier.weight(1f), onClick = { viewModel.onAction(CalculatorAction.Number(2)) })
                CalculatorButton(text = "3", type = CalculatorButtonType.Normal, modifier = Modifier.weight(1f), onClick = { viewModel.onAction(CalculatorAction.Number(3)) })
                CalculatorButton(text = "+", type = CalculatorButtonType.Primary, modifier = Modifier.weight(1f), onClick = { viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add)) })
            }
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                CalculatorButton(text = "0", type = CalculatorButtonType.Normal, modifier = Modifier.weight(2f), isWide = true, onClick = { viewModel.onAction(CalculatorAction.Number(0)) })
                CalculatorButton(text = ".", type = CalculatorButtonType.Normal, modifier = Modifier.weight(1f), onClick = { viewModel.onAction(CalculatorAction.Decimal) })
                CalculatorButton(text = "=", type = CalculatorButtonType.Primary, modifier = Modifier.weight(1f), onClick = { viewModel.onAction(CalculatorAction.Calculate) })
            }
        }
    }
}
