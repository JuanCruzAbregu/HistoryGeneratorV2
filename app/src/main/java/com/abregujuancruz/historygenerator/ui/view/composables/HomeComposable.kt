package com.abregujuancruz.historygenerator.ui.view.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.abregujuancruz.historygenerator.R
import com.abregujuancruz.historygenerator.ui.theme.HistoryDesignTheme
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState.FirstLoad
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState.HomeComposableModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.HorizontalShowcaseModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.IdeasRectangleBannerModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.ToolbarModel

@Composable
fun HomeComposable(homeComposableState: HomeComposableState) {
    HistoryDesignTheme {
        when (homeComposableState) {
            is FirstLoad -> {
                //TODO: PlaceHolder
            }
            is HomeComposableModel -> {
                ToolbarComposable(
                    toolbarModel = homeComposableState
                        .toolbarModel
                )
                //TODO: ADD BUTTON
                HorizontalShowcaseComposable(
                    horizontalShowcaseModel = homeComposableState
                        .horizontalShowcaseModel
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeComposablePreview() {
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
        toolbarModel = ToolbarModel(
            infoIcon = { }
        ),
        horizontalShowcaseModel = HorizontalShowcaseModel(
            bannerList = bannerList,
            startIcon = R.drawable.ic_baseline_android_24
        )
    )
    HomeComposable(homeComposableState = model)
}