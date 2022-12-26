package com.abregujuancruz.historygenerator.ui.view.composables.screen.info

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abregujuancruz.historygenerator.R
import com.abregujuancruz.historygenerator.ui.theme.HistoryDesignTheme
import com.abregujuancruz.historygenerator.ui.theme.White
import com.abregujuancruz.historygenerator.ui.view.composables.toolbar.ToolbarComposable

@Composable
fun InfoScreenComposable() {
    HistoryDesignTheme {
        Column {
            ToolbarComposable()
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .wrapContentSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_avatar),
                        contentDescription = null,
                        modifier = Modifier
                            .height(200.dp)
                            .width(200.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(id = R.string.develop_by),
                        fontSize = 18.sp,
                        color = White
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun InfoScreenComposablePreview() {
    InfoScreenComposable()
}