package com.brawijaya.mgminventory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.brawijaya.mgminventory.domain.usecase.onboarding.getOnBoardingItem
import com.brawijaya.mgminventory.ui.onboarding.OnboardingScreen
import com.brawijaya.mgminventory.ui.theme.MGMInventoryTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashscreen = installSplashScreen()
        var keepSplashScreen = true
        super.onCreate(savedInstanceState)
        splashscreen.setKeepOnScreenCondition { keepSplashScreen }
        lifecycleScope.launch {
            delay(3000)
            keepSplashScreen = false
        }
        enableEdgeToEdge()
        setContent {
            MGMInventoryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val showOnboardingState = remember { mutableStateOf(true) }
                    val showOnboarding = showOnboardingState.value

                    if (showOnboarding) {
                        OnboardingScreen(
                            onboardingItems = getOnBoardingItem(),
                            onFinishOnboarding = {
                                // Here you would typically save a preference
                                // that the user has completed onboarding
                                showOnboardingState.value = false
                            }
                        )
                    } else {
                        Greeting(
                            name = "Android"
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        style = MaterialTheme.typography.displayMedium,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MGMInventoryTheme {
        Greeting("Android")
    }
}