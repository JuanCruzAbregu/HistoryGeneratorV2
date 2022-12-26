package com.abregujuancruz.historygenerator.ui.view.composables.core

import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.abregujuancruz.historygenerator.R
import com.abregujuancruz.historygenerator.utils.Actionable

@Composable
internal fun ClickableIcon(
    @DrawableRes icon: Int,
    iconColor: Color? = null,
    contentDescription: String? = null,
    @DimenRes size: Int = R.dimen.size24,
    action: Actionable,
    modifier: Modifier
) {
    if (iconColor != null) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = contentDescription,
            tint = iconColor,
            modifier = modifier
                .size(dimensionResource(id = size))
                .clickable {
                    action.invoke()
                }
        )
    } else {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = contentDescription,
            modifier = Modifier
                .size(dimensionResource(id = size))
                .clickable {
                    action.invoke()
                },
            tint = Color.Unspecified
        )
    }
}