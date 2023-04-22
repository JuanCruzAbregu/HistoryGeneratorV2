package com.abregujuancruz.historygenerator.ui.view.composables.banners

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abregujuancruz.historygenerator.ui.theme.HistoryDesignTheme
import com.abregujuancruz.historygenerator.ui.theme.Teal500
import com.abregujuancruz.historygenerator.ui.view.composables.models.HeaderHomeBannerModel

@Composable
fun HeaderHomeBanner(
    headerHomeBannerModel: HeaderHomeBannerModel
) {
    HistoryDesignTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Button(
                onClick = headerHomeBannerModel.generateHistory,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Teal500
                ),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
            ) {
                Text(
                    text = "Hola",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@Preview
@Composable
fun HeaderHomeBannerPreview() {
    HeaderHomeBanner(headerHomeBannerModel = HeaderHomeBannerModel(
        generateHistory = { }
    ))
}