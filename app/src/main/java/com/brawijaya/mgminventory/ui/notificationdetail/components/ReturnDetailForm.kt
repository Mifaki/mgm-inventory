package com.brawijaya.mgminventory.ui.notificationdetail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.brawijaya.mgminventory.R
import com.brawijaya.mgminventory.data.model.ReturnNotificationDetail
import com.brawijaya.mgminventory.ui.components.MGMScaffold

@Composable
fun ReturnDetailForm(navController: NavHostController, notificationId: String) {
    val returnData = remember {
        ReturnNotificationDetail(
            title = "Berhasil Dikembalikan",
            endTime = "Aug 11, 2020 at 12:08 PM",
            borrowDate = "11-07-2020",
            returnDate = "11-08-2020",
            item = "Joystick",
            proofImageUrl = "Alat.jpg"
        )
    }

    MGMScaffold(
        title = "Detail Notifikasi",
        showBackButton = true,
        navController = navController
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.boarding_2),
                        contentDescription = "Success Image",
                        modifier = Modifier.fillMaxWidth().aspectRatio(4f / 3f)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = returnData.title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "End Time: ${returnData.endTime}",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Data Pengembalian",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            DataField(label = "Tanggal Peminjaman", value = returnData.borrowDate)

            Spacer(modifier = Modifier.height(8.dp))

            DataField(label = "Tanggal Pengembalian", value = returnData.returnDate)

            Spacer(modifier = Modifier.height(8.dp))

            DataField(label = "Alat yang Dikembalikan", value = returnData.item)

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Foto Bukti Alat Dikembalikan",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(200.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clip(RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cato),
                        contentDescription = "Proof Image",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


@Composable
fun DataField(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = value,
            onValueChange = { },
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFFDDDDDD),
                unfocusedContainerColor = Color.White
            )
        )
    }
}