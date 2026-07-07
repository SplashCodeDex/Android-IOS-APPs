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
import com.dexstudio.core.sharedui.*
import com.dexstudio.core.sharedui.theme.DeXStudioTheme
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
      DeXStudioTheme {
        Scaffold(
          topBar = { GlassNavigation(title = "Calculator Pro") },
          modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
          Column(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
             HeroSection(
                 title = "Math. Redefined.",
                 subtitle = "A calculation experience like no other.",
                 isDark = false
             ) {
                 Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                     PrimaryCTA(text = "Start Calculating", onClick = { })
                     PillLink(text = "Learn more", isDarkBg = false, onClick = { })
                 }
             }
             HeroSection(
                 title = "Engine Diagnostics",
                 subtitle = "Powered by DeXStudio Core SDK",
                 isDark = true
             ) {
                 Text(
                     text = data,
                     style = com.dexstudio.core.sharedui.theme.AppTypography.bodyLarge,
                     color = com.dexstudio.core.sharedui.theme.PureWhite,
                     modifier = Modifier.padding(16.dp)
                 )
             }
          }
        }
      }
    }
  }
}
