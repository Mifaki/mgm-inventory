package com.brawijaya.mgminventory.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.brawijaya.mgminventory.data.model.BottomNavItem
import com.brawijaya.mgminventory.ui.navigation.Screen

@Composable
fun MGMBottomBar(
    items: List<BottomNavItem>,
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit,
    navController: NavHostController,
) {
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(16.dp, shape = RectangleShape, clip = false)
            .background(Color.White),
        containerColor = Color.White
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    onItemSelected(index)
                    when (index) {
                        0 -> navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) { inclusive = true }
                        }
                        1 -> navController.navigate(Screen.BorrowForm.route) {
                            popUpTo(Screen.Home.route)
                        }
                        2 -> navController.navigate(Screen.History.route) {
                            popUpTo(Screen.Home.route)
                        }
                        3 -> navController.navigate(Screen.Profile.route) {
                            popUpTo(Screen.Home.route)
                        }
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconResId),
                        contentDescription = item.title,
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = Color(0xFF21272A),
                    indicatorColor = MaterialTheme.colorScheme.secondary
                )
            )
        }
    }
}