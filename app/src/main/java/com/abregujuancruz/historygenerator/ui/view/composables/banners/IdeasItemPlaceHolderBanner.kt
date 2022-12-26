package com.abregujuancruz.historygenerator.ui.view.composables.banners

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abregujuancruz.historygenerator.ui.theme.HistoryDesignTheme
import com.abregujuancruz.historygenerator.ui.theme.Placeholder
import com.abregujuancruz.historygenerator.ui.theme.Placeholder2

@Composable
fun IdeasItemPlaceHolderBanner() {
    HistoryDesignTheme {
        Card(
            elevation = 8.dp,
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .background(
                            shape = MaterialTheme.shapes.large,
                            color = Placeholder2
                        )
                        .height(18.dp)
                        .width(76.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Spacer(
                    modifier = Modifier
                        .background(
                            shape = MaterialTheme.shapes.large,
                            color = Placeholder
                        )
                        .height(16.dp)
                        .fillMaxWidth()
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview
@Composable
fun IdeasItemPlaceHolderBannerPreview(){
    IdeasItemPlaceHolderBanner()
}