package com.abregujuancruz.historygenerator.ui.view.composables.banners

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abregujuancruz.historygenerator.ui.view.composables.models.HorizontalShowcaseModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.IdeasRectangleBannerModel

@Composable
fun HorizontalShowcaseBanner(
    horizontalShowcaseModel: HorizontalShowcaseModel
) {
    if (horizontalShowcaseModel.bannerList.isNotEmpty()) {
        val horizontalMarginLong = 16.dp
        val bannerList = horizontalShowcaseModel.bannerList
        val listState = rememberLazyListState()
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
        ) {
            val lastIndex = bannerList.size - 1
            items(
                count = bannerList.size,
            ) { item ->
                Spacer(modifier = Modifier.height(8.dp))
                IdeasItemBanner(
                    ideasRectangleBannerModel = bannerList[item]
                )
                if (item == lastIndex) {
                    Spacer(modifier = Modifier.height(horizontalMarginLong))
                }
            }
        }
    }
}

@Preview
@Composable
fun HorizontalShowcaseBannerPreview() {
    val bannerList = listOf(
        IdeasRectangleBannerModel(
            label = "Label",
            description = "Description"
        ),
        IdeasRectangleBannerModel(
            label = "Label",
            description = "Description"
        ),
        IdeasRectangleBannerModel(
            label = "Label",
            description = "Description"
        ),
        IdeasRectangleBannerModel(
            label = "Label",
            description = "Description"
        ),
        IdeasRectangleBannerModel(
            label = "Label",
            description = "Description"
        )
    )

    val model = HorizontalShowcaseModel(
        bannerList = bannerList
    )

    HorizontalShowcaseBanner(horizontalShowcaseModel = model)
}