package com.abregujuancruz.historygenerator.ui.view.composables.banners

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abregujuancruz.historygenerator.R
import com.abregujuancruz.historygenerator.ui.theme.HistoryDesignTheme
import com.abregujuancruz.historygenerator.ui.theme.Red
import com.abregujuancruz.historygenerator.ui.view.composables.models.HeaderHomeBannerModel

@Composable
fun EmptyScreenBanner(
    headerHomeBannerModel: HeaderHomeBannerModel
){
    HistoryDesignTheme {
        Surface(
            color = Red,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.ic_baseline_contact_support_24
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .wrapContentSize(),
                    contentScale = ContentScale.Crop
                )
                Text(
                    modifier = Modifier
                        .padding(top = 24.dp, bottom = 8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    text = "¡Nada por aquí!",
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier
                        .padding(end = 16.dp, start = 16.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    text = "Presiona el botón para generar nuevas ideas",
                    textAlign = TextAlign.Center
                )
                HeaderHomeBanner(headerHomeBannerModel = headerHomeBannerModel)
            }
        }
    }
}

@Preview
@Composable
fun EmptyScreenBannerPreview(){
    val model = HeaderHomeBannerModel(
        generateHistory = {}
    )
    EmptyScreenBanner(model)
}