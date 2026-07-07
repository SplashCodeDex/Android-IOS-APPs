import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import com.dexstudio.core.sharedui.*
import com.dexstudio.core.sharedui.theme.DeXStudioTheme
import com.dexstudio.core.shareddata.CoreRepository
import com.dexstudio.core.shareddata.di.coreModule
import com.dexstudio.core.shareddata.di.desktopCoreModule
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent.inject
import kotlinx.coroutines.launch
import org.koin.core.context.stopKoin

fun main() = application {
    DisposableEffect(Unit) {
        startKoin {
            modules(coreModule, desktopCoreModule())
        }
        onDispose {
            stopKoin()
        }
    }

    val repository: CoreRepository by inject(CoreRepository::class.java)
    var data by remember { mutableStateOf("Loading...") }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            data = repository.getAppConfig()
        }
    }

    Window(
        onCloseRequest = ::exitApplication,
        title = "DeXStudio Desktop",
    ) {
        DeXStudioTheme {
            Column(modifier = Modifier.fillMaxSize()) {
                GlassNavigation(title = "Desktop Architecture")
                HeroSection(
                    title = "Desktop. Redefined.",
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
