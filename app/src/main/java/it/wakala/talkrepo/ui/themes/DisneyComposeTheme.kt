package it.wakala.talkrepo.ui.themes

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import it.wakala.talkrepo.ui.themes.Colors.background
import it.wakala.talkrepo.ui.themes.Colors.background800
import it.wakala.talkrepo.ui.themes.Colors.purple200
import it.wakala.talkrepo.ui.themes.Colors.purple500

private val DarkColorPalette = darkColors(
  background = background,
  onBackground = background800,
  primary = purple200,
  primaryVariant = purple500,
  secondary = purple500,
  onPrimary = Color.White,
  onSecondary = Color.White
)

private val LightColorPalette = lightColors(
  background = Color.White,
  onBackground = Color.White,
  surface = Color.White,
  primary = purple200,
  primaryVariant = purple500,
  secondary = purple500,
  onPrimary = Color.White,
  onSecondary = Color.White
)

@Composable
fun RepoForTalkComposeTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit
) {
  val colors = if (darkTheme) {
    DarkColorPalette
  } else {
    LightColorPalette
  }

  val typography = if (darkTheme) {
    Type.DarkTypography
  } else {
    Type.LightTypography
  }

  MaterialTheme(
    colors = colors,
    typography = typography,
    shapes = shapes,
    content = content
  )
}