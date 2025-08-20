package br.com.jvdc.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val SmallSpacing = 4.dp
val MediumSpacing = 8.dp
val LargeSpacing = 16.dp

val AppShapes = Shapes(
    small = RoundedCornerShape(SmallSpacing),
    medium = RoundedCornerShape(MediumSpacing),
    large = RoundedCornerShape(LargeSpacing)
)