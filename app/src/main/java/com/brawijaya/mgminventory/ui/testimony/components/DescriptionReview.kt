package com.brawijaya.mgminventory.ui.testimony.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brawijaya.mgminventory.R

@Preview(showBackground = true)
@Composable
fun DescriptionReview() {
    Column(
        Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Column(
            Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            HorizontalDivider()
            Row(
                Modifier.padding(10.dp, 0.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Sort by: ",
                    color = Color.Gray,
                )
                Row(
                    Modifier
                        .clip(CircleShape)
                        .background(colorResource(R.color.blue_200).copy(alpha = 0.2f))
                        .padding(15.dp, 5.dp)
                ) {
                    Text(
                        "Newest"
                    )
                }
            }
            HorizontalDivider()
        }
        Column(
            Modifier.fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text("Sempurna", style = TextStyle(
                    fontWeight = FontWeight.Bold, fontSize = 20.sp
                ))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    repeat(5){
                        Image(
                            painter = painterResource(R.drawable.star_filled),
                            contentDescription = "Stars Rating"
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(
                        "David Ramadhan",
                        style = TextStyle(
                            color = Color.Gray
                        )
                    )
                    Text(
                        "•",
                        style = TextStyle(
                            color = Color.Gray
                        )
                    )
                    Text(
                        "David Ramadhan",
                        style = TextStyle(
                            color = Color.Gray
                        )
                    )
                }
                Text(
                    "Alur  peminjamannya lancar, jelas dan di administrasinya mudah. Best pokoknya",
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 15.sp
                    )
                )
            }
        }
        Column(
            Modifier.fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text("Sempurna", style = TextStyle(
                    fontWeight = FontWeight.Bold, fontSize = 20.sp
                ))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    repeat(5){
                        Image(
                            painter = painterResource(R.drawable.star_filled),
                            contentDescription = "Stars Rating"
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(
                        "David Ramadhan",
                        style = TextStyle(
                            color = Color.Gray
                        )
                    )
                    Text(
                        "•",
                        style = TextStyle(
                            color = Color.Gray
                        )
                    )
                    Text(
                        "David Ramadhan",
                        style = TextStyle(
                            color = Color.Gray
                        )
                    )
                }
                Text(
                    "Alur  peminjamannya lancar, jelas dan di administrasinya mudah. Best pokoknya",
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 15.sp
                    )
                )
            }
        }
    }
}