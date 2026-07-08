package com.example.apptwo.di

import com.example.apptwo.domain.calculator.CalculateResultUseCase
import com.example.apptwo.presentation.viewmodel.CalculatorViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory { CalculateResultUseCase() }
    viewModel { CalculatorViewModel(get()) }
}
