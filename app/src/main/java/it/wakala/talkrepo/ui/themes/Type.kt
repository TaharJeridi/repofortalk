package it.wakala.talkrepo.ui.themes

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import it.wakala.talkrepo.ui.themes.Colors.background800
import it.wakala.talkrepo.ui.themes.Colors.background900
import it.wakala.talkrepo.ui.themes.Colors.white87

object Type {

    val DarkTypography = Typography(
        h1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 28.sp
        ),
        h2 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 21.sp
        ),
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            fontSize = 14.sp
        ),
        body2 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            color = white87,
            fontSize = 14.sp
        )
    )

    val LightTypography = Typography(
        h1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            color = background900,
            fontSize = 28.sp
        ),
        h2 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            color = background900,
            fontSize = 21.sp
        ),
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            color = background800,
            fontSize = 14.sp
        ),
        body2 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            color = background800,
            fontSize = 14.sp
        )
    )

}