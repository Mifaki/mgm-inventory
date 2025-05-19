package com.brawijaya.mgminventory.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brawijaya.mgminventory.data.model.StatItem
import kotlin.collections.forEach

@Composable
fun BarChart(
    values: List<StatItem>,
    maxHeight: Dp = 120.dp
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(maxHeight),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom
            ) {
                values.forEach { barData ->
                    BarItem(
                        value = barData.value,
                        isActive = barData.isActive,
                        maxHeight = maxHeight
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                values.forEach { barData ->
                    Box(
                        modifier = Modifier.width(40.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Text(
                            text = barData.label,
                            fontSize = 10.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .graphicsLayer {
                                    rotationZ = -45f
                                    transformOrigin = androidx.compose.ui.graphics.TransformOrigin(0.5f, 0f)
                                }.offset(x = (-24).dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun BarItem(
    value: Float,
    isActive: Boolean,
    maxHeight: Dp
) {
    val heightPercent = value / 100f
    val itemHeight = maxHeight * heightPercent

    Box(
        modifier = Modifier
            .width(16.dp)
            .height(maxHeight)
            .background(
                Color(0xFFF0F0F0),
                RoundedCornerShape(8.dp)
            )
    ) {
        Box(
            modifier = Modifier
                .width(16.dp)
                .height(itemHeight)
                .align(Alignment.BottomCenter)
                .background(
                    if (isActive) Color(0xFF5DB075) else Color(0xFFF0F0F0),
                    RoundedCornerShape(8.dp)
                )
        )
    }
}