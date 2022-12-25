package com.abregujuancruz.historygenerator.ui.view.composables.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.abregujuancruz.historygenerator.ui.view.composables.banners.EmptyScreenBanner
import com.abregujuancruz.historygenerator.ui.view.composables.models.HeaderHomeBannerModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState.EmptyHomeComposableModel
import com.abregujuancruz.historygenerator.ui.view.composables.toolbar.ToolbarComposable

@Composable
fun EmptyHomeScreenComposable(
    emptyHomeComposableState: HomeComposableState
) {
    if (emptyHomeComposableState is EmptyHomeComposableModel) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            ToolbarComposable()
        }
        EmptyScreenBanner(
            headerHomeBannerModel = emptyHomeComposableState
                .headerHomeBannerModel
        )
    }
}

@Preview
@Composable
fun EmptyHomeScreenComposablePreview() {
    val model = EmptyHomeComposableModel(
        headerHomeBannerModel = HeaderHomeBannerModel { }
    )
    EmptyHomeScreenComposable(
        emptyHomeComposableState = model
    )
}
