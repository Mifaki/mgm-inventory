package com.brawijaya.mgminventory.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.brawijaya.mgminventory.ui.borrow.BorrowScreen
import com.brawijaya.mgminventory.ui.borrowform.BorrowFormScreen
import com.brawijaya.mgminventory.ui.calender.CalendarScreen
import com.brawijaya.mgminventory.ui.home.HomeScreen
import com.brawijaya.mgminventory.ui.itemreturn.ItemReturnScreen
import com.brawijaya.mgminventory.ui.punishment.PunishmentScreen
import com.brawijaya.mgminventory.ui.returnForm.ReturnFormScreen
import com.brawijaya.mgminventory.ui.statistic.StatisticScreen
import java.time.LocalDate

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Borrow : Screen("borrow")
    object ItemReturn : Screen("item_return")
    object Punishment : Screen("punishment")
    object Statistic : Screen("statistic")
    object BorrowForm : Screen("borrow_form")
    object ReturnForm: Screen("return_form")

    object Calendar : Screen("calendar/{title}/{dateType}") {
        fun createRoute(title: String, dateType: String): String {
            return "calendar/$title/$dateType"
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    // Shared date selection callback for the Calendar screen
    val onDateSelected = remember<(String, String) -> Unit> { { date, dateType ->
        navController.previousBackStackEntry?.savedStateHandle?.set("selected_date", date)
        navController.previousBackStackEntry?.savedStateHandle?.set("date_type", dateType)
        navController.navigateUp()
    }}


    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(Screen.Borrow.route) {
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

        composable(Screen.BorrowForm.route) {
            BorrowFormScreen(navController = navController)
        }

        composable(Screen.ReturnForm.route) {
            ReturnFormScreen(navController = navController)
        }

        composable(
            route = Screen.Calendar.route,
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("dateType") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: "Kalender"
            val dateType = backStackEntry.arguments?.getString("dateType") ?: ""

            CalendarScreen(
                navController = navController,
                title = title,
                initialDate = LocalDate.now(),
                onDateSelected = { date ->
                    onDateSelected(date, dateType)
                }
            )
        }
    }
}