package com.abregujuancruz.historygenerator.ui.view.composables.models


sealed interface HomeComposableState {
    data class HomeComposableModel(
        val horizontalShowcaseModel: HorizontalShowcaseModel,
    ): HomeComposableState

    data class EmptyHomeComposableModel(
        val headerHomeBannerModel: HeaderHomeBannerModel
    ): HomeComposableState

    object FirstLoad: HomeComposableState
}