package com.brawijaya.mgminventory.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.brawijaya.mgminventory.R
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.StepSize

@Composable
fun RatingStars(
    initialRating: Float = 0f,
    isEditable: Boolean = true,
    onRatingChanged: (Float) -> Unit = {}
) {
    var rating by remember { mutableStateOf(initialRating) }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        RatingBar(
            value = rating,
            onValueChange = {
                if (isEditable) {
                    rating = it
                    onRatingChanged(it)
                }
            },
            onRatingChanged = {
               rating = it
            },
            painterEmpty = painterResource(id = R.drawable.star_stroke),
            painterFilled = painterResource(id = R.drawable.star_filled),
            numOfStars = 5,
            size = 20.dp,
            spaceBetween = 2.dp,
            isIndicator = !isEditable,
            stepSize = StepSize.HALF
        )
    }
}

// Read-only version for displaying existing ratings
@Composable
fun RatingDisplay(rating: Float) {
    RatingStars(
        initialRating = rating,
        isEditable = false
    )
}