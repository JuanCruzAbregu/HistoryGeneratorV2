package com.abregujuancruz.historygenerator.ui.view.composables.models

sealed interface HomeComposableState {
    data class HomeComposableModel(
        val toolbarModel: ToolbarModel,
        val horizontalShowcaseModel: HorizontalShowcaseModel
    ): HomeComposableState

    object FirstLoad: HomeComposableState
}