package com.brawijaya.mgminventory.ui.profiledetail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.brawijaya.mgminventory.R
import com.brawijaya.mgminventory.data.model.UserProfileData
import com.brawijaya.mgminventory.ui.components.ReadOnlyTextField

@Composable
fun IdentityForm(userData: UserProfileData) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Identitas Diri",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(bottom = 8.dp),
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(16.dp))

        ReadOnlyTextField(
            label = "NIM",
            value = userData.nim
        )

        Spacer(modifier = Modifier.height(16.dp))

        ReadOnlyTextField(
            label = "Fakultas",
            value = userData.faculty
        )

        Spacer(modifier = Modifier.height(16.dp))

        ReadOnlyTextField(
            label = "Program Studi",
            value = userData.studyProgram
        )

        Spacer(modifier = Modifier.height(16.dp))

        ReadOnlyTextField(
            label = "Student Email",
            value = userData.email
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Text(
                text = "Kartu Tanda Mahasiswa",
                style = MaterialTheme.typography.labelMedium,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFDDDDDD),
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.student_card),
                    contentDescription = "Student ID Card",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }
    }
}
