package com.abregujuancruz.historygenerator.ui.view.composables.screen.home

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abregujuancruz.historygenerator.ui.theme.HistoryDesignTheme
import com.abregujuancruz.historygenerator.ui.theme.Teal500
import com.abregujuancruz.historygenerator.ui.view.composables.banners.HorizontalShowcaseBanner
import com.abregujuancruz.historygenerator.ui.view.composables.core.DialogConfirmation
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState
import com.abregujuancruz.historygenerator.ui.view.composables.models.HomeComposableState.HomeComposableModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.HorizontalShowcaseModel
import com.abregujuancruz.historygenerator.ui.view.composables.models.IdeasRectangleBannerModel
import com.abregujuancruz.historygenerator.ui.view.composables.toolbar.ToolbarComposable

@Composable
fun NonEmptyScreenComposable(
    nonEmptyHomeComposableState: HomeComposableState,
) {
    if (nonEmptyHomeComposableState is HomeComposableModel) {
        val context = LocalContext.current
        val openDialog = remember {
            mutableStateOf(false)
        }
        HistoryDesignTheme {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                ToolbarComposable()
                Button(
                    onClick = { openDialog.value = !openDialog.value },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Teal500
                    ),
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                ) {
                    Text(
                        text = "Generar",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                if(openDialog.value){
                    DialogConfirmation(
                        title = "Generar nuevas ideas",
                        description = "¿Está seguro que desea generar nuevas ideas? " +
                            "Los datos anteriores se perderán.",
                        onDismiss = { openDialog.value = !openDialog.value },
                    ) {
                        val activity = (context as? Activity)
                        activity?.finish()
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalShowcaseBanner(
                    horizontalShowcaseModel = nonEmptyHomeComposableState
                        .horizontalShowcaseModel
                )
            }
        }
    }
}

@Preview
@Composable
fun NonEmptyScreenComposablePreview() {
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
        horizontalShowcaseModel = HorizontalShowcaseModel(
            bannerList = bannerList,
        ),
    )
    NonEmptyScreenComposable(model)
}