package com.brawijaya.mgminventory.ui.testimony.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brawijaya.mgminventory.R

@Preview(showBackground = true)
@Composable
fun TotalRating() {
    Column(
        Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.End
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .heightIn(max = 150.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "5.0",
                    fontWeight = FontWeight.Bold,
                    fontSize = 48.sp,
                )
                Text(
                    "out of 5.0",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }
            Column(
                Modifier.weight(1f).fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                for (i in 5 downTo  1) {
                    Row(
                        Modifier.fillMaxWidth().padding(0.dp, 7.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        repeat(i){
                            Image(
                                painter = painterResource(R.drawable.star_filled),
                                contentDescription = "Stars"
                            )
                        }
                    }
                }
            }
            Column(
                Modifier.weight(1f).fillMaxHeight().padding(0.dp, 7.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(5){
                    Row (
                        Modifier
                            .fillMaxWidth()
                            .height(12.dp)
                            .background(Color.White)
                            .border(1.dp, Color.Black)
                    ){}
                }
            }
        }
    }
}