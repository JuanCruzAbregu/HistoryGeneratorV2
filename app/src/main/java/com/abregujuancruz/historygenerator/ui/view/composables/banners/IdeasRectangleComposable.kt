package com.abregujuancruz.historygenerator.ui.view.composables.banners

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abregujuancruz.historygenerator.ui.theme.HistoryDesignTheme
import com.abregujuancruz.historygenerator.ui.view.composables.models.IdeasRectangleBannerModel

@Composable
fun IdeasRectangleComposable(
    ideasRectangleBannerModel: IdeasRectangleBannerModel
) {
    HistoryDesignTheme {
        Card(
            elevation = 8.dp,
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = ideasRectangleBannerModel.label,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = ideasRectangleBannerModel
                        .description,
                    fontStyle = FontStyle.Italic,
                    fontSize = 14.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview
@Composable
fun IdeasRectangleComposablePreview() {
    val model = IdeasRectangleBannerModel(
        label = "Label",
        description = "Description"
    )

    IdeasRectangleComposable(ideasRectangleBannerModel = model)
}