package com.abregujuancruz.historygenerator.ui.view.composables.core.models

import androidx.compose.ui.window.DialogProperties

data class ConfirmDialogModel(
    val title: String,
    val description: String,
    val properties: DialogProperties = DialogProperties(),
    val onDismiss: () -> Unit,
    val onConfirm: () -> Unit
)