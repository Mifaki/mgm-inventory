package com.brawijaya.mgminventory.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.brawijaya.mgminventory.ui.borrow.BorrowScreen
import com.brawijaya.mgminventory.ui.home.HomeScreen
import com.brawijaya.mgminventory.ui.itemreturn.ItemReturnScreen
import com.brawijaya.mgminventory.ui.punishment.PunishmentScreen
import com.brawijaya.mgminventory.ui.statistic.StatisticScreen


sealed class Screen(val route: String){
    object Home : Screen("home")
    object Borrow: Screen("borrow")
    object ItemReturn: Screen("item_return")
    object Punishment: Screen("punishment")
    object Statistic: Screen("statistic")
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(Screen.Borrow.route ) {
            BorrowScreen(navController = navController)
        }

        composable(Screen.ItemReturn.route) {
            ItemReturnScreen(navController = navController)
        }

        composable(Screen.Punishment.route) {
            PunishmentScreen(navController = navController)
        }

        composable(Screen.Statistic.route) {
            StatisticScreen(navController = navController)
        }
    }
}