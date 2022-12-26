package com.abregujuancruz.historygenerator.ui.view.composables.banners

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abregujuancruz.historygenerator.ui.theme.ButtonPlaceholder
import com.abregujuancruz.historygenerator.ui.theme.HistoryDesignTheme

@Preview
@Composable
fun HeaderHomePlaceHolderBanner() {
    HistoryDesignTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Spacer(
                modifier = Modifier
                    .background(
                        shape = MaterialTheme.shapes.large,
                        color = ButtonPlaceholder
                    )
                    .height(40.dp)
                    .fillMaxWidth()
            )
        }
    }
}
