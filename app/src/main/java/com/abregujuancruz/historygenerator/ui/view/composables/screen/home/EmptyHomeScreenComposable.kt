package com.abregujuancruz.historygenerator.ui.view.composables.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
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
import com.abregujuancruz.historygenerator.ui.theme.White
import com.abregujuancruz.historygenerator.ui.view.composables.banners.HeaderHomeBanner
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
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            ToolbarComposable()
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
                color = White,
                fontWeight = FontWeight.Bold,
                text = "¡Nada por aquí!",
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .padding(end = 16.dp, start = 16.dp),
                fontSize = 14.sp,
                color = White,
                fontWeight = FontWeight.Medium,
                text = "Presiona el botón para generar nuevas ideas",
                textAlign = TextAlign.Center
            )
            HeaderHomeBanner(
                headerHomeBannerModel = emptyHomeComposableState
                    .headerHomeBannerModel
            )
        }
    }
}

@Preview
@Composable
fun EmptyComposablePreview() {
    val model = EmptyHomeComposableModel(
        headerHomeBannerModel = HeaderHomeBannerModel(
            generateHistory = {}
        )
    )

    EmptyHomeScreenComposable(
        emptyHomeComposableState = model
    )
}
