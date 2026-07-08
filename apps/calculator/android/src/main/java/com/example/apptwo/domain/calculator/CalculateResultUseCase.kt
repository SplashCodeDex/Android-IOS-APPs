package com.example.apptwo.domain.calculator

class CalculateResultUseCase {
    operator fun invoke(state: CalculatorState): CalculatorState {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        
        if (number1 != null && number2 != null && state.operation != null) {
            val result = when (state.operation) {
                CalculatorOperation.Add -> number1 + number2
                CalculatorOperation.Subtract -> number1 - number2
                CalculatorOperation.Multiply -> number1 * number2
                CalculatorOperation.Divide -> if (number2 != 0.0) number1 / number2 else return state.copy(number1 = "Error", number2 = "", operation = null)
            }
            
            // Format result (remove trailing .0 if integer)
            var resultString = result.toString()
            if (resultString.endsWith(".0")) {
                resultString = resultString.dropLast(2)
            }
            
            return state.copy(
                number1 = resultString.take(15),
                number2 = "",
                operation = null
            )
        }
        return state
    }
}
