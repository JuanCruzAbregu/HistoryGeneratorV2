package com.abregujuancruz.historygenerator.ui.view.composables.toolbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abregujuancruz.historygenerator.R
import com.abregujuancruz.historygenerator.ui.theme.HistoryDesignTheme
import com.abregujuancruz.historygenerator.ui.theme.White
import com.abregujuancruz.historygenerator.ui.theme.caudex

@Composable
fun ToolbarComposable() {
    HistoryDesignTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 18.sp,
                fontFamily = caudex,
                fontWeight = FontWeight.Bold,
                color = White
            )
        }
    }
}

@Preview
@Composable
fun ToolbarComposablePreview() {
    ToolbarComposable()
}