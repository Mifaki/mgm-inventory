package com.brawijaya.mgminventory.ui.calender

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.brawijaya.mgminventory.ui.components.MGMScaffold
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.*

@Composable
fun CalendarScreen(
    navController: NavHostController,
    title: String,
    initialDate: LocalDate = LocalDate.now(),
    onDateSelected: (String) -> Unit
) {
    var currentYearMonth by remember { mutableStateOf(YearMonth.from(initialDate)) }
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }
    val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    MGMScaffold(
        title = title,
        showBackButton = true,
        showBottomBar = false,
        navController = navController
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val month = currentYearMonth.month.getDisplayName(TextStyle.FULL, Locale("id"))
                val year = currentYearMonth.year

                Text(
                    text = "$month $year",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
                )

                Row {
                    IconButton(onClick = {
                        currentYearMonth = currentYearMonth.minusMonths(1)
                    }) {
                        Icon(Icons.Default.KeyboardArrowLeft, contentDescription = "Previous Month")
                    }

                    IconButton(onClick = {
                        currentYearMonth = currentYearMonth.plusMonths(1)
                    }) {
                        Icon(Icons.Default.KeyboardArrowRight, contentDescription = "Next Month")
                    }
                }
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                val daysOfWeek = listOf(
                    DayOfWeek.MONDAY,
                    DayOfWeek.TUESDAY,
                    DayOfWeek.WEDNESDAY,
                    DayOfWeek.THURSDAY,
                    DayOfWeek.FRIDAY,
                    DayOfWeek.SATURDAY,
                    DayOfWeek.SUNDAY
                )

                for (day in daysOfWeek) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        val dayName = when (day) {
                            DayOfWeek.MONDAY -> "Mon"
                            DayOfWeek.TUESDAY -> "Tue"
                            DayOfWeek.WEDNESDAY -> "Wed"
                            DayOfWeek.THURSDAY -> "Thu"
                            DayOfWeek.FRIDAY -> "Fri"
                            DayOfWeek.SATURDAY -> "Sat"
                            DayOfWeek.SUNDAY -> "Sun"
                        }

                        Text(
                            text = dayName,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            color = if (day == DayOfWeek.SUNDAY) Color.Red else Color.Unspecified,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            val firstDayOfMonth = currentYearMonth.atDay(1)

            // Find the first day to display (the Monday before or on the first day of the month)
            var currentDay = firstDayOfMonth
            while (currentDay.dayOfWeek != DayOfWeek.MONDAY) {
                currentDay = currentDay.minusDays(1)
            }

            repeat(6) { rowIndex ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    repeat(7) { columnIndex ->
                        val day = currentDay
                        val isCurrentMonth = day.month == currentYearMonth.month
                        val isToday = day.equals(LocalDate.now())
                        val isSelected = day.equals(selectedDate)

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .padding(4.dp)
                                .background(
                                    color = when {
                                        isSelected -> MaterialTheme.colorScheme.primary
                                        isToday -> Color(0xFFE6E6FA)
                                        else -> Color.Transparent
                                    },
                                    shape = RoundedCornerShape(9999.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            if (isCurrentMonth) {
                                val isSunday = day.dayOfWeek == DayOfWeek.SUNDAY

                                Text(
                                    text = day.dayOfMonth.toString(),
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = when {
                                        isSelected -> Color.White
                                        isSunday -> Color.Red
                                        !isCurrentMonth -> Color.Gray
                                        else -> Color.Unspecified
                                    },
                                    modifier = Modifier.clickable {
                                        selectedDate = day
                                    }
                                )
                            }
                        }

                        currentDay = currentDay.plusDays(1)
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Tidak ada peminjaman terdaftar",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val dateToReturn = selectedDate ?: LocalDate.now()
                    val formattedDate = dateToReturn.format(dateFormatter)
                    onDateSelected(formattedDate)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Simpan", modifier = Modifier.padding(vertical = 8.dp))
            }
        }
    }
}