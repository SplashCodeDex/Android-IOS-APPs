package com.example.apptwo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dexstudio.core.sharedui.designsystem.theme.DeXStudioTheme
import com.example.apptwo.presentation.ui.screen.CalculatorScreen
import com.example.apptwo.presentation.viewmodel.CalculatorViewModel
import com.dexstudio.core.sharedui.designsystem.component.GlassNavigation
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

  private val viewModel: CalculatorViewModel by inject()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    enableEdgeToEdge()
    setContent {
      DeXStudioTheme {
        Scaffold(
          topBar = { GlassNavigation(title = "Calculator Pro") },
          modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
          CalculatorScreen(viewModel = viewModel)
        }
      }
    }
  }
}
