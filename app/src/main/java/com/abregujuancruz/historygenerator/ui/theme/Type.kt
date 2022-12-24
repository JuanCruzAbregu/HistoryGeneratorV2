package com.abregujuancruz.historygenerator.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.abregujuancruz.historygenerator.R

val caudex = FontFamily(
    Font(R.font.caudex_regular, FontWeight.Normal),
    Font(R.font.caudex_regular, FontWeight.Light),
    Font(R.font.caudex_bold, FontWeight.Bold)
)

val HGTypography = Typography(
    h1 = TextStyle(
        fontFamily = caudex,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    h2 = TextStyle(
        fontFamily = caudex,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    h3 = TextStyle(
        fontFamily = caudex,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    h4 = TextStyle(
        fontFamily = caudex,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    h5 = TextStyle(
        fontFamily = caudex,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    h6 = TextStyle(
        fontFamily = caudex,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp
    ),
    body1 = TextStyle(
        fontFamily = caudex,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    caption = TextStyle(
        fontFamily = caudex,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp
    )
)