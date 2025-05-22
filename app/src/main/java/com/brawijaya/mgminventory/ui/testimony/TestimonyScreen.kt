package com.brawijaya.mgminventory.ui.testimony

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.brawijaya.mgminventory.ui.components.MGMScaffold
import com.brawijaya.mgminventory.ui.testimony.components.DescriptionReview
import com.brawijaya.mgminventory.ui.testimony.components.RatingBar
import com.brawijaya.mgminventory.ui.testimony.components.TotalRating

@Composable
fun TestimonyScreen(
    navController: NavHostController
){
    MGMScaffold(
        title = "Testimoni",
        showBackButton = true,
        navController = navController
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 24.dp, end = 24.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ){
            TotalRating()
            RatingBar()
            DescriptionReview()
        }
    }
}
