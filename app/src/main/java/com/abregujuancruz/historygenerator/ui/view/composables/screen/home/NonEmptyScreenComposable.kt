package com.abregujuancruz.historygenerator.ui.view.composables.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.abregujuancruz.historygenerator.ui.view.composables.banners.HeaderHomeBanner
import com.abregujuancruz.historygenerator.ui.view.composables.banners.HorizontalShowcaseBanner
import com.abregujuancruz.historygenerator.ui.view.composables.models.HeaderHomeBannerModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState.HomeComposableModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.HorizontalShowcaseModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.IdeasRectangleBannerModel
import com.abregujuancruz.historygenerator.ui.view.composables.toolbar.ToolbarComposable

@Composable
fun NonEmptyScreenComposable(
    nonEmptyHomeComposableState: HomeComposableState
) {
    if (nonEmptyHomeComposableState is HomeComposableModel) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            ToolbarComposable()
            HeaderHomeBanner(
                headerHomeBannerModel = nonEmptyHomeComposableState
                    .headerHomeBannerModel
            )
            HorizontalShowcaseBanner(
                horizontalShowcaseModel = nonEmptyHomeComposableState
                    .horizontalShowcaseModel
            )
        }
    }
}

@Preview
@Composable
fun NonEmptyScreenComposablePreview() {
    val bannerList = listOf(
        IdeasRectangleBannerModel(
            label = "label",
            description = "asdasda abfjbafibaf fhaisfnanfin"
        ),
        IdeasRectangleBannerModel(
            label = "label",
            description = "asdasda abfjbafibaf fhaisfnanfin"
        ),
        IdeasRectangleBannerModel(
            label = "label",
            description = "asdasda abfjbafibaf fhaisfnanfin"
        ),
        IdeasRectangleBannerModel(
            label = "label",
            description = "asdasda abfjbafibaf fhaisfnanfin"
        ),
        IdeasRectangleBannerModel(
            label = "label",
            description = "asdasda abfjbafibaf fhaisfnanfin"
        )
    )

    val model = HomeComposableModel(
        horizontalShowcaseModel = HorizontalShowcaseModel(
            bannerList = bannerList,
        ),
        headerHomeBannerModel = HeaderHomeBannerModel(
            generateHistory = { }
        )
    )
    NonEmptyScreenComposable(model)
}