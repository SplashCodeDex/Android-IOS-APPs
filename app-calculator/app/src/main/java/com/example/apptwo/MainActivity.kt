package com.example.apptwo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    
    var data by mutableStateOf("Loading...")
    lifecycleScope.launch {
        data = repository.getAppConfig()
    }
    
    setContent {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            CoreHeader(title = "Calculator Dashboard")
            Text(
              text = data,
              modifier = Modifier.padding(16.dp)
            )
          }
        }
    }
  }
}
