package com.abregujuancruz.historygenerator.ui.view.composables.banners

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abregujuancruz.historygenerator.ui.theme.HistoryDesignTheme

@Preview
@Composable
fun HorizontalShowcasePlaceHolderBanner() {
    val horizontalMarginLong = 16.dp
    val bannerList = listOf(1, 2, 3, 4, 5, 6)
    HistoryDesignTheme {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 16.dp,
                    end = 16.dp
                )
        ) {
            val lastIndex = bannerList.size - 1
            itemsIndexed(bannerList) { item, _ ->
                Spacer(modifier = Modifier.height(8.dp))
                IdeasItemPlaceHolderBanner()
                if (item == lastIndex) {
                    Spacer(modifier = Modifier.height(horizontalMarginLong))
                }
            }
        }
    }
}