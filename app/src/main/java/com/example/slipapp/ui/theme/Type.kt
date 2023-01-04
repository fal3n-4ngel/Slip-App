package com.example.slipapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.slipapp.R

val Poppins = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_light, FontWeight.Light)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        color = DarkCyan
    ),
    h2 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    caption = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        color = Color(0xFF969696),
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        color = DarkGray,
        fontSize = 12.sp
    ),
)