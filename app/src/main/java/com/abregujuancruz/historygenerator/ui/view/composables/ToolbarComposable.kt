package com.abregujuancruz.historygenerator.ui.view.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abregujuancruz.historygenerator.R
import com.abregujuancruz.historygenerator.ui.theme.HistoryDesignTheme
import com.abregujuancruz.historygenerator.ui.theme.White
import com.abregujuancruz.historygenerator.ui.theme.caudex
import com.abregujuancruz.historygenerator.ui.view.composables.core.ClickableIcon
import com.abregujuancruz.historygenerator.ui.view.composables.models.ToolbarModel

@Composable
fun ToolbarComposable(toolbarModel: ToolbarModel) {
    HistoryDesignTheme {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_android_24),
                contentDescription = null
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 18.sp,
                fontFamily = caudex,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = White
            )
            Spacer(modifier = Modifier.weight(1f))
            ClickableIcon(
                icon = R.drawable.ic_baseline_info_24,
                iconColor = White,
                modifier = Modifier,
                action = { toolbarModel.infoIcon.invoke() }
            )
        }
    }
}

@Preview
@Composable
fun ToolbarComposablePreview() {
    ToolbarComposable(toolbarModel = ToolbarModel(
        infoIcon = { }
    ))
}