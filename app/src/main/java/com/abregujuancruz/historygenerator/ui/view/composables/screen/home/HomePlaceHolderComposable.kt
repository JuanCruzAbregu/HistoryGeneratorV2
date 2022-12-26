package com.abregujuancruz.historygenerator.ui.view.composables.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.abregujuancruz.historygenerator.ui.theme.HistoryDesignTheme
import com.abregujuancruz.historygenerator.ui.view.composables.banners.HeaderHomePlaceHolderBanner
import com.abregujuancruz.historygenerator.ui.view.composables.banners.HorizontalShowcasePlaceHolderBanner
import com.abregujuancruz.historygenerator.ui.view.composables.toolbar.ToolbarComposable

@Preview
@Composable
fun HomePlaceHolderComposable() {
    HistoryDesignTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            ToolbarComposable()
            HeaderHomePlaceHolderBanner()
            HorizontalShowcasePlaceHolderBanner()
        }
    }
}