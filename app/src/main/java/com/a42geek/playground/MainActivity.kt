package com.a42geek.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                    val competedStep = remember { mutableStateOf(0) }
                    StepsProgressBar(modifier = Modifier.fillMaxWidth(), numberOfSteps = 5, completedStep = competedStep.value)
                }
            }
        }
    }
}


@Composable
fun Content() {
    val completedStep = remember { mutableStateOf(0) }
    StepsProgressBar(modifier = Modifier.fillMaxWidth(), numberOfSteps = 5, completedStep = completedStep.value)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PlaygroundTheme {

    }
}