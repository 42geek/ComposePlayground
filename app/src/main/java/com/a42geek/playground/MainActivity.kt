package com.a42geek.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.a42geek.playground.components.LinearProgressIndicator
import com.a42geek.playground.components.StepsProgressBar
import com.a42geek.playground.ui.theme.PlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Content()
                }
            }
        }
    }
}


@Composable
fun Content() {
    val currentStep = remember { mutableStateOf(1) }

    Column(
        modifier = Modifier.fillMaxWidth().padding(32.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        StepsProgressBar(modifier = Modifier.fillMaxWidth(), numberOfSteps = 5, currentStep = currentStep.value)

        Spacer(modifier = Modifier.height(40.dp))

        LinearProgressIndicator (
            modifier = Modifier.fillMaxWidth(),
            progress = 0.5F,
            color = Color.Blue,
            backgroundColor = Color.Gray,
            cap = StrokeCap.Round
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PlaygroundTheme {
        Content()
    }
}