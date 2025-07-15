package com.brawijaya.mgminventory.ui.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.brawijaya.mgminventory.R
import com.brawijaya.mgminventory.ui.login.components.LoginForm
import com.brawijaya.mgminventory.utlis.Resource

@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel(),
) {
    val loginState by viewModel.loginState.collectAsState()

    var email by remember {
        mutableStateOf("")
    };
    var password by remember {
        mutableStateOf("")
    };

    val isFilled = email.isNotEmpty() && password.isNotEmpty();
    val context = LocalContext.current

    Column(
        Modifier
            .fillMaxSize()
            .background(colorResource(R.color.blue_200)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            Modifier
                .weight(1f)
                .background(colorResource(R.color.blue_200))
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.mgm_logotext),
                contentDescription = "MGM Logo Text",
                Modifier.graphicsLayer {
                    scaleX = 2.5f
                    scaleY = 2.5f
                }
            )
        }
        Column(
            Modifier
                .weight(3f)
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(Color.White)
                .padding(top = 35.dp, start = 24.dp, end = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            Column(
                Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    "Masuk ke MGM",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left
                )
            }

            LoginForm(
                email = email,
                password = password,
                onEmailChange = { email = it },
                onPasswordChange = { password = it }
            )

            Button(
                onClick = {
                    viewModel.login(email, password)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray,
                    contentColor = Color.White
                ),
                enabled = isFilled
            ) {
                when (loginState) {
                    is Resource.Loading -> {
                        CircularProgressIndicator(
                            color = Color.White,
                            strokeWidth = 2.dp,
                            modifier = Modifier
                                .size(22.dp)
                        )
                    }

                    else -> {
                        Text("Login")
                    }
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                )
                Text(
                    "atau",
                    fontSize = 14.sp
                )
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                )
            }
            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .border(0.5.dp, Color.Black, RoundedCornerShape(8.dp)),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.google_icon),
                        contentDescription = "Google Logo",
                        Modifier
                            .graphicsLayer {
                                scaleX = 0.75f
                                scaleY = 0.75f
                            }
                    )
                    Text(
                        "Masuk dengan Google"
                    )
                }
            }
            Row (
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    "Sudah memiliki akun?",
                    style = TextStyle(
                        fontSize = 14.sp
                    )
                )
                Text(
                    "Masuk",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                    ),
                    modifier = Modifier.clickable {  }
                )
            }
            Text(
                "Lupa Password",
                textDecoration = TextDecoration.Underline,
                fontSize = 14.sp
            )
        }

        when (loginState) {
            is Resource.Success -> {
                LaunchedEffect(Unit) {
                    Toast.makeText(context, "Login Success", Toast.LENGTH_LONG).show()
                }
            }

            is Resource.Error -> {
                val message = (loginState as Resource.Error).message
                LaunchedEffect(message) {
                    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                }
            }

            else -> {}
        }
    }
}