package com.a42geek.playground.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

private val LinearIndicatorHeight = ProgressIndicatorDefaults.StrokeWidth
private val LinearIndicatorWidth = 240.dp

@Composable
fun LinearProgressIndicator(
    /*@FloatRange(from = 0.0, to = 1.0)*/
    progress: Float,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.primary,
    backgroundColor: Color = color.copy(alpha = ProgressIndicatorDefaults.IndicatorBackgroundOpacity),
    cap: StrokeCap = Stroke.DefaultCap
) {
    val padding = if (cap == StrokeCap.Round) 2.dp else 0.dp

    Canvas(modifier
        .progressSemantics(progress)
        .size(LinearIndicatorWidth, LinearIndicatorHeight)
        .padding(start = padding, end = padding)
    ) {
        val strokeWidth = size.height
        drawLinearIndicatorBackground(backgroundColor, strokeWidth, cap)
        drawLinearIndicator(0f, progress, color, strokeWidth, cap)
    }
}

private fun DrawScope.drawLinearIndicator(
    startFraction: Float,
    endFraction: Float,
    color: Color,
    strokeWidth: Float,
    cap: StrokeCap
) {
    val width = size.width
    val height = size.height
    // Start drawing from the vertical center of the stroke
    val yOffset = height / 2

    val isLtr = layoutDirection == LayoutDirection.Ltr
    val barStart = (if (isLtr) startFraction else 1f - endFraction) * width
    val barEnd = (if (isLtr) endFraction else 1f - startFraction) * width

    // Progress line
    drawLine(color, Offset(barStart, yOffset), Offset(barEnd, yOffset), strokeWidth, cap = cap)
}

private fun DrawScope.drawLinearIndicatorBackground(
    color: Color,
    strokeWidth: Float,
    cap: StrokeCap
) = drawLinearIndicator(0f, 1f, color, strokeWidth, cap)
