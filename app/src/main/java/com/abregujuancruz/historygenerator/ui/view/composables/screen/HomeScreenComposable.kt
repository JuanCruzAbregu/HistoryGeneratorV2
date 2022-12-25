package com.abregujuancruz.historygenerator.ui.view.composables.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.abregujuancruz.historygenerator.R
import com.abregujuancruz.historygenerator.ui.theme.HistoryDesignTheme
import com.abregujuancruz.historygenerator.ui.view.composables.models.HeaderHomeBannerModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState.EmptyHomeComposableModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState.FirstLoad
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState.HomeComposableModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.HorizontalShowcaseModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.IdeasRectangleBannerModel

@Composable
fun HomeScreenComposable(
    homeComposableState: HomeComposableState
) {
    HistoryDesignTheme {
        when (homeComposableState) {
            is FirstLoad -> {
                EmptyHomeScreenComposable(
                    emptyHomeComposableState = homeComposableState
                )
            }
            is HomeComposableModel -> {
                NonEmptyScreenComposable(
                    nonEmptyHomeComposableState = homeComposableState
                )
            }
            is EmptyHomeComposableModel -> {
                EmptyHomeScreenComposable(
                    emptyHomeComposableState = homeComposableState
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenComposablePreview() {
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
            startIcon = R.drawable.ic_baseline_android_24
        ),
        headerHomeBannerModel = HeaderHomeBannerModel(
            generateHistory = { }
        )
    )
    HomeScreenComposable(homeComposableState = model)
}

@Preview
@Composable
fun EmptyScreenComposablePreview() {
    val model = EmptyHomeComposableModel(
        headerHomeBannerModel = HeaderHomeBannerModel(
            generateHistory = {}
        )
    )

    EmptyHomeScreenComposable(
        emptyHomeComposableState = model
    )
}