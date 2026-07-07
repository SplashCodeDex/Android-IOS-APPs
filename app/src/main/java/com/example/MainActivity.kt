package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.theme.MyApplicationTheme
import com.dexstudio.core.sharedui.CoreHeader
import com.dexstudio.core.shareddata.CoreRepository
import org.koin.android.ext.android.inject
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
  private val repository: CoreRepository by inject()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    
    var data by mutableStateOf("Loading...")
    lifecycleScope.launch {
        data = repository.getAppConfig()
    }

    setContent {
      MyApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            CoreHeader(title = "AppHide Dashboard")
            Text(
              text = data,
              style = MaterialTheme.typography.bodyLarge,
              modifier = Modifier.padding(16.dp)
            )
          }
        }
      }
    }
  }
}

