package com.a42geek.playground.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StepsProgressBar(
    modifier: Modifier = Modifier,
    numberOfSteps: Int,
    currentStep: Int
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (step in 0..numberOfSteps) {
            Step(
                modifier = Modifier.weight(1F),
                isCompeted = step < currentStep,
                isCurrent = step == currentStep
            )
        }
    }
}

@Composable
fun Step(
    modifier: Modifier = Modifier,
    isCompeted: Boolean,
    isCurrent: Boolean
) {
    val lineThickness = 2.dp
    val circleSize = 15.dp

    val color = if (isCompeted || isCurrent) Color.Red else Color.LightGray
    val innerCircleColor = if (isCompeted) Color.Red else Color.LightGray

    Box(modifier = modifier) {

        //Line
        Divider(
            modifier = Modifier.align(Alignment.CenterStart),
            color = color,
            thickness = lineThickness
        )

        //Circle
        Canvas(modifier = Modifier
            .size(circleSize)
            .align(Alignment.CenterEnd)
            .border(
                shape = CircleShape,
                width = lineThickness,
                color = color
            ),
            onDraw = {
                drawCircle(color = innerCircleColor)
            }
        )
    }
}

@Preview
@Composable
fun StepsProgressBarPreview() {
    val currentStep = remember { mutableStateOf(0) }
    StepsProgressBar(modifier = Modifier.fillMaxWidth(), numberOfSteps = 5, currentStep = currentStep.value)
}