package com.necatisozer.balloontest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.necatisozer.balloontest.ui.theme.BalloonTestTheme
import com.skydoves.balloon.ArrowPositionRules
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.BalloonSizeSpec
import com.skydoves.balloon.compose.Balloon
import com.skydoves.balloon.compose.rememberBalloonBuilder
import com.skydoves.balloon.compose.setBackgroundColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BalloonTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        // create and remember a builder of Balloon.
                        val builder = rememberBalloonBuilder {
                            setArrowSize(10)
                            setArrowPosition(0.5f)
                            setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
                            setWidth(BalloonSizeSpec.WRAP)
                            setHeight(BalloonSizeSpec.WRAP)
                            setPadding(12)
                            setMarginHorizontal(12)
                            setCornerRadius(8f)
                            setBackgroundColor(Color.Cyan)
                            setBalloonAnimation(BalloonAnimation.ELASTIC)
                        }

                        Balloon(modifier = Modifier.align(Alignment.Center),
                            builder = builder,
                            balloonContent = {
                                Text(text = "Now you can edit your profile!")
                            }) { balloonWindow ->
                            Button(onClick = {
                                balloonWindow.showAlignTop() // display your balloon.
                            }) {
                                Text(text = "showAlignTop")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BalloonTestTheme {
        Greeting("Android")
    }
}