package com.brawijaya.mgminventory.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.brawijaya.mgminventory.domain.onboarding.getOnBoardingItem
import com.brawijaya.mgminventory.ui.borrow.BorrowScreen
import com.brawijaya.mgminventory.ui.borrowform.BorrowFormScreen
import com.brawijaya.mgminventory.ui.calender.CalendarScreen
import com.brawijaya.mgminventory.ui.home.HomeScreen
import com.brawijaya.mgminventory.ui.itemreturn.ItemReturnScreen
import com.brawijaya.mgminventory.ui.login.LoginScreen
import com.brawijaya.mgminventory.ui.notification.NotificationScreen
import com.brawijaya.mgminventory.ui.notificationdetail.NotificationDetailScreen
import com.brawijaya.mgminventory.ui.onboarding.OnboardingScreen
import com.brawijaya.mgminventory.ui.profile.ProfileScreen
import com.brawijaya.mgminventory.ui.profiledetail.ProfileDetailScreen
import com.brawijaya.mgminventory.ui.punishment.PunishmentScreen
import com.brawijaya.mgminventory.ui.returnForm.ReturnFormScreen
import com.brawijaya.mgminventory.ui.statistic.StatisticScreen
import com.brawijaya.mgminventory.ui.testimony.TestimonyScreen
import java.time.LocalDate

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Borrow : Screen("borrow")
    object ItemReturn : Screen("item_return")
    object Punishment : Screen("punishment")
    object Statistic : Screen("statistic")
    object BorrowForm : Screen("borrow_form")
    object ReturnForm: Screen("return_form")
    object Notification: Screen("notification")
    object Profile: Screen("profile")
    object ProfileDetail: Screen("profile_detail")
    object Testimony: Screen("testimony")
    object Login: Screen("login")
    object Onboarding: Screen("onboarding")

    object NotificationDetail: Screen("notification_detail/{type}/{id}") {
        fun createRoute(type: String, id: String): String {
            return "notification_detail/$type/$id"
        }
    }

    object Calendar : Screen("calendar/{title}/{dateType}") {
        fun createRoute(title: String, dateType: String): String {
            return "calendar/$title/$dateType"
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController, startDestination: String = Screen.Home.route) {
    // Shared date selection callback for the Calendar screen
    val onDateSelected = remember<(String, String) -> Unit> { { date, dateType ->
        navController.previousBackStackEntry?.savedStateHandle?.set("selected_date", date)
        navController.previousBackStackEntry?.savedStateHandle?.set("date_type", dateType)
        navController.navigateUp()
    }}


    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Onboarding.route) {
            OnboardingScreen(
                onboardingItems = getOnBoardingItem(),
                onFinishOnboarding = {
//                    navController.navigate(Screen.Register.route)
                },
                onLoginClicked = {
                    navController.navigate(Screen.Login.route)
                },
                navController = navController
            )
        }

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

        composable(Screen.Notification.route) {
            NotificationScreen(navController = navController)
        }

        composable(Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }

        composable(Screen.ProfileDetail.route) {
            ProfileDetailScreen(navController = navController)
        }

        composable(Screen.Testimony.route) {
            TestimonyScreen(navController = navController)
        }

        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }

        composable(
            route = Screen.NotificationDetail.route,
            arguments = listOf(
                navArgument("type") { type = NavType.StringType },
                navArgument("id") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val type = backStackEntry.arguments?.getString("type") ?: "return"
            val id = backStackEntry.arguments?.getString("id") ?: ""

            NotificationDetailScreen(
                navController = navController,
                notificationType = type,
                notificationId = id
            )
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