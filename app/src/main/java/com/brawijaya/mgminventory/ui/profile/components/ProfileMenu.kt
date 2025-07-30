package com.brawijaya.mgminventory.ui.profile.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.brawijaya.mgminventory.R
import com.brawijaya.mgminventory.ui.navigation.Screen
import com.brawijaya.mgminventory.ui.profile.ProfileViewModel

@Composable
fun ProfileMenu(navController: NavHostController, viewModel: ProfileViewModel) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = (-24).dp)
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            ProfileMenuItem(
                icon = R.drawable.profile,
                title = "My Account",
                subtitle = "Edit your account",
                showToggle = false,
                onClick = {
                    navController.navigate(Screen.ProfileDetail.route)
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            ProfileMenuItem(
                icon = R.drawable.lock,
                title = "Face ID / Touch ID",
                subtitle = "Manage your device security",
                showToggle = true,
                onClick = {
                    // Handle Face ID
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            ProfileMenuItem(
                icon = R.drawable.shield,
                title = "Two-Factor Authentication",
                subtitle = "Further secure your account for safety",
                showToggle = false,
                onClick = {
                    // Navigate to two-factor auth settings
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            ProfileMenuItem(
                icon = R.drawable.logout,
                title = "Log out",
                subtitle = "Further secure your account for safety",
                showToggle = false,
                onClick = {
                    viewModel.logout()
                    Toast.makeText(context, "Logged out", Toast.LENGTH_SHORT).show()
                    navController.navigate(Screen.Login.route) {
                        popUpTo(0) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun ProfileMenuItem(
    icon: Any,
    title: String,
    subtitle: String,
    showToggle: Boolean = false,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color(0xFFF0F0FF)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(icon as Int),
                contentDescription = null,
                tint = Color(0xFF4355F9),
                modifier = Modifier.size(24.dp)
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )
            Text(
                text = subtitle,
                color = Color.Gray,
                fontSize = 14.sp
            )
        }

        if (showToggle) {
            Switch(
                checked = false,
                onCheckedChange = { },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFF4355F9)
                )
            )
        } else {
            IconButton(onClick = onClick) {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowRight,
                    contentDescription = "Navigate",
                    tint = Color.Gray
                )
            }
        }
    }
}