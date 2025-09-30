package com.example.exertion.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = EXERTION_RED,
    onPrimary = ON_EXERTION_RED,
    primaryContainer = EXERTION_RED_CONTAINER,
    onPrimaryContainer = ON_EXERTION_RED_CONTAINER,
    secondary = SURFACE_02,
    onSecondary = ON_TEXT_SOFT,
    secondaryContainer = SURFACE_03,
    onSecondaryContainer = ON_TEXT_STRONG,
    tertiary = TERTIARY_COLOR,
    onTertiary = ON_TEXT_SOFT,
    tertiaryContainer = TERTIARY_CONTAINER,
    onTertiaryContainer = ON_TEXT_STRONG,
    background = BLACK_COLOR,
    onBackground = ON_TEXT_STRONG,
    surface = SURFACE_01,
    onSurface = ON_TEXT_STRONG,
    surfaceVariant = SURFACE_02,
    onSurfaceVariant = ON_TEXT_MUTED,
    error = ERROR,
    onError = ON_ERROR,
    errorContainer = ERROR_CONTAINER,
    onErrorContainer = ON_ERROR_CONTAINER,
    outline = OUTLINE,
    outlineVariant = OUTLINE_VARIANT,
    inverseSurface = ON_TEXT_STRONG,
    inverseOnSurface = SURFACE_01,
    inversePrimary = INVERSE_PRIMARY,
    scrim = SCRIM
)

private val LightColorScheme = lightColorScheme(
    primary = EXERTION_RED,
    onPrimary = ON_EXERTION_RED,
    primaryContainer = EXERTION_RED_CONTAINER_L,
    onPrimaryContainer = ON_EXERTION_RED_CONTAINER_L,
    secondary = SECONDARY_L,
    onSecondary = ON_SECONDARY_L,
    secondaryContainer = SURFACE_02_L,
    onSecondaryContainer = ON_TEXT_STRONG_L,
    tertiary = TERTIARY_L,
    onTertiary = ON_TERTIARY_L,
    tertiaryContainer = SURFACE_03_L,
    onTertiaryContainer = ON_TEXT_STRONG_L,
    background = PAPER_WHITE,
    onBackground = ON_TEXT_STRONG_L,
    surface = SURFACE_01_L,
    onSurface = ON_TEXT_STRONG_L,
    surfaceVariant = SURFACE_02_L,
    onSurfaceVariant = ON_TEXT_MUTED_L,
    error = ERROR_L,
    onError = ON_ERROR_L,
    errorContainer = ERROR_CONTAINER_L,
    onErrorContainer = ON_ERROR_CONTAINER_L,
    outline = OUTLINE_L,
    outlineVariant = OUTLINE_VARIANT_L,
    inverseSurface = INVERSE_SURFACE_L,
    inverseOnSurface = INVERSE_ON_SURFACE_L,
    inversePrimary = INVERSE_PRIMARY_L,
    scrim = SCRIM
)

@Composable
fun ExertionTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}