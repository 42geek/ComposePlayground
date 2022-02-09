package com.a42geek.playground.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StepsProgressBar(modifier: Modifier = Modifier, numberOfSteps: Int, completedStep: Int) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (step in 0..numberOfSteps) {
            Step(
                modifier = Modifier.weight(1F),
                isCompete = step <= completedStep
            )
        }
    }
}

@Composable
fun Step(modifier: Modifier = Modifier, isCompete: Boolean) {
    val color = if (isCompete) {
        MaterialTheme.colors.primary
    } else {
        MaterialTheme.colors.secondary
    }

    Box(modifier = modifier) {

        //Line
        Divider(modifier = Modifier.align(Alignment.CenterStart), color = color, thickness = 2.dp)

        //Circle
        Canvas(modifier = Modifier.size(15.dp).align(Alignment.CenterEnd), onDraw = {
            drawCircle(color = color)
        })
    }
}