package com.example.apptwo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.apptwo.domain.calculator.CalculateResultUseCase
import com.example.apptwo.domain.calculator.CalculatorAction
import com.example.apptwo.domain.calculator.CalculatorOperation
import com.example.apptwo.domain.calculator.CalculatorState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CalculatorViewModel(
    private val calculateResultUseCase: CalculateResultUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CalculatorState())
    val state: StateFlow<CalculatorState> = _state.asStateFlow()

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> _state.update { CalculatorState() }
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Delete -> performDeletion()
        }
    }

    private fun performDeletion() {
        _state.update { currentState ->
            when {
                currentState.number2.isNotBlank() -> currentState.copy(
                    number2 = currentState.number2.dropLast(1)
                )
                currentState.operation != null -> currentState.copy(
                    operation = null
                )
                currentState.number1.isNotBlank() -> currentState.copy(
                    number1 = currentState.number1.dropLast(1)
                )
                else -> currentState
            }
        }
    }

    private fun performCalculation() {
        _state.update { currentState ->
            calculateResultUseCase(currentState)
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        _state.update { currentState ->
            if (currentState.number1.isNotBlank()) {
                currentState.copy(operation = operation)
            } else {
                currentState
            }
        }
    }

    private fun enterDecimal() {
        _state.update { currentState ->
            if (currentState.operation == null && !currentState.number1.contains(".")
                && currentState.number1.isNotBlank()) {
                currentState.copy(number1 = currentState.number1 + ".")
            } else if (currentState.operation != null && !currentState.number2.contains(".")
                && currentState.number2.isNotBlank()) {
                currentState.copy(number2 = currentState.number2 + ".")
            } else {
                currentState
            }
        }
    }

    private fun enterNumber(number: Int) {
        _state.update { currentState ->
            if (currentState.operation == null) {
                if (currentState.number1.length >= 15) return@update currentState
                currentState.copy(number1 = currentState.number1 + number)
            } else {
                if (currentState.number2.length >= 15) return@update currentState
                currentState.copy(number2 = currentState.number2 + number)
            }
        }
    }
}
