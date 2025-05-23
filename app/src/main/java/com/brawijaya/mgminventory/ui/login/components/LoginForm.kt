package com.brawijaya.mgminventory.ui.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brawijaya.mgminventory.R

@Preview(showBackground = true)
@Composable
fun LoginForm() {
    Column(
        Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Column (
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                "Email",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Row(
                Modifier
                    .height(52.dp)
                    .fillMaxWidth()
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .background(Color.Transparent, RoundedCornerShape(8.dp))
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart,
                ) {
                    BasicTextField(
                        value = "",
                        onValueChange = {
                        },
                        textStyle = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Black
                        ),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "Masukkan emailmu...",
                        style = TextStyle(fontSize = 14.sp, color = Color.Gray),
                        modifier = Modifier.align(Alignment.CenterStart)
                    )
                }
                Image(
                    painter = painterResource(R.drawable.eraser_icon),
                    contentDescription = "Eraser Icon",
                    Modifier.size(20.dp)
                )
            }
        }
        Column (
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                "Kata Sandi",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Row(
                Modifier
                    .height(52.dp)
                    .fillMaxWidth()
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .background(Color.Transparent, RoundedCornerShape(8.dp))
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart,
                ) {
                    BasicTextField(
                        value = "",
                        onValueChange = {
                        },
                        textStyle = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Black
                        ),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "Masukkan kata sandimu...",
                        style = TextStyle(fontSize = 14.sp, color = Color.Gray),
                        modifier = Modifier.align(Alignment.CenterStart)
                    )
                }
                Image(
                    painter = painterResource(R.drawable.eraser_icon),
                    contentDescription = "Eraser Icon",
                    Modifier.size(20.dp)
                )
            }
        }
    }
}