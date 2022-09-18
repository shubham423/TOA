package com.example.affirmationtask.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.affirmationtask.R

private val UrbanistExtraBold = FontFamily(Font(R.font.urbanist_extrabold))
private val UrbanistSemiBold = FontFamily(Font(R.font.urbanist_semibold))
private val UrbanistBold = FontFamily(Font(R.font.urbanist_bold))
private val UrbanistMedium = FontFamily(Font(R.font.urbanist_medium))
private val UrbanistLight = FontFamily(Font(R.font.urbanist_light))

val typography = Typography(
    h1 = TextStyle(
        fontFamily = UrbanistExtraBold,
        fontSize = 40.sp,
    ),
    h2 = TextStyle(
        fontFamily = UrbanistExtraBold,
        fontSize = 36.sp,
    ),
    h3 = TextStyle(
        fontFamily = UrbanistSemiBold,
        fontSize = 13.sp,
    ),
    subtitle1 = TextStyle(
        fontFamily = UrbanistMedium,
        fontSize = 15.sp,
    ),

    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)
