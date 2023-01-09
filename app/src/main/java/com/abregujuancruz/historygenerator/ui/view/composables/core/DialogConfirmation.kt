package com.abregujuancruz.historygenerator.ui.view.composables.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abregujuancruz.historygenerator.ui.theme.HistoryDesignTheme
import com.abregujuancruz.historygenerator.ui.theme.Shapes
import com.abregujuancruz.historygenerator.ui.view.composables.core.models.ConfirmDialogModel

@Composable
fun DialogConfirmation(
    confirmDialogModel: ConfirmDialogModel
) {
    HistoryDesignTheme {
        Card(
            elevation = 8.dp,
            modifier = Modifier
                .height(180.dp),
            shape = Shapes.medium
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = confirmDialogModel.title,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = confirmDialogModel.description,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
                Box(
                    contentAlignment = Alignment.BottomCenter,
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        OutlinedButton(
                            modifier = Modifier
                                .wrapContentHeight()
                                .weight(0.5f),
                            onClick = { confirmDialogModel.onDismiss }
                        ) {
                            Text(text = "Cancelar")
                        }
                        Spacer(modifier = Modifier.width(16.dp))

                        OutlinedButton(
                            modifier = Modifier
                                .weight(0.5f)
                                .wrapContentHeight(),
                            onClick = { confirmDialogModel.onConfirm }
                        ) {
                            Text(text = "Confirmar")
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewDialogConfirmation() {
    val model = ConfirmDialogModel(
        title = "Generar nuevas ideas",
        description = "¿Está seguro que desea generar nuevas ideas? " +
            "Los datos anteriores se perderán.",
        onConfirm = {},
        onDismiss = {}
    )
    DialogConfirmation(confirmDialogModel = model)
}

