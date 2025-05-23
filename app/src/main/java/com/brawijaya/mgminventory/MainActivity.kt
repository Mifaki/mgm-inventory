package com.brawijaya.mgminventory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.brawijaya.mgminventory.domain.onboarding.getOnBoardingItem
import com.brawijaya.mgminventory.ui.navigation.AppNavigation
import com.brawijaya.mgminventory.ui.navigation.Screen
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
                    color = Color.White
                ) {
                    val showOnboardingState = remember { mutableStateOf(true) }
                    val showOnboarding = showOnboardingState.value

                    val navController = rememberNavController()
                    AppNavigation(navController = navController)

                    if (showOnboarding) {
                        OnboardingScreen(
                            onboardingItems = getOnBoardingItem(),
                            onFinishOnboarding = {
                                showOnboardingState.value = false
                            },
                            onLoginClicked = {
                                navController.navigate(Screen.Login.route)
                            },
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}