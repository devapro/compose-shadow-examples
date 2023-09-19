package pro.devapp.shadowdemo

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.godaddy.android.colorpicker.harmony.ColorHarmonyMode
import com.godaddy.android.colorpicker.harmony.HarmonyColorPicker

@Composable
fun NativeShadow() {
    var elevation by remember { mutableStateOf(10f) }
    var ambientColor by remember {
        mutableStateOf(Color.Black)
    }
    var spotColor by remember {
        mutableStateOf(Color.Black)
    }

    val scroll = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize().verticalScroll(
        state = scroll
    )) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .scrollable(
                    state = rememberScrollState(),
                    orientation = Orientation.Vertical
                )
        ) {

            Text(
                text = "Native shadow",
                color = Color.Black,
                modifier = Modifier.testTag("NativeShadowScreen")
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Box(
                            modifier = Modifier
                                .shadow(
                                    elevation = elevation.dp,
                                    shape = RectangleShape,
                                    ambientColor = ambientColor,
                                    spotColor = spotColor
                                )
                                .width(50.dp)
                                .height(50.dp)
                                .background(
                                    color = Color.Transparent,
                                    shape = RectangleShape
                                )
                        )
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Box(
                            modifier = Modifier
                                .shadow(
                                    elevation = elevation.dp,
                                    shape = RoundedCornerShape(10.dp),
                                    ambientColor = ambientColor,
                                    spotColor = spotColor
                                )
                                .width(50.dp)
                                .height(50.dp)
                                .background(
                                    color = Color.Transparent,
                                    shape = RoundedCornerShape(10.dp)
                                )
                        )
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Box(
                            modifier = Modifier
                                .shadow(
                                    elevation = elevation.dp,
                                    shape = CircleShape,
                                    ambientColor = ambientColor,
                                    spotColor = spotColor
                                )
                                .width(50.dp)
                                .height(50.dp)
                                .background(
                                    color = Color.Transparent,
                                    shape = CircleShape
                                )
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Box(
                            modifier = Modifier
                                .shadow(
                                    elevation = elevation.dp,
                                    shape = RectangleShape,
                                    ambientColor = ambientColor,
                                    spotColor = spotColor
                                )
                                .width(50.dp)
                                .height(50.dp)
                                .background(
                                    color = Color.White,
                                    shape = RectangleShape
                                )
                        )
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Box(
                            modifier = Modifier
                                .shadow(
                                    elevation = elevation.dp,
                                    shape = RoundedCornerShape(10.dp),
                                    ambientColor = ambientColor,
                                    spotColor = spotColor
                                )
                                .width(50.dp)
                                .height(50.dp)
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(10.dp)
                                )
                        )
                    }
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Box(
                            modifier = Modifier
                                .shadow(
                                    elevation = elevation.dp,
                                    shape = CircleShape,
                                    ambientColor = ambientColor,
                                    spotColor = spotColor
                                )
                                .width(50.dp)
                                .height(50.dp)
                                .background(
                                    color = Color.White,
                                    shape = CircleShape
                                )
                        )
                    }
                }
            }

            Text(
                text = "Elevation ${elevation}",
                color = Color.Black
            )
            Slider(
                value = elevation,
                onValueChange = { elevation = it },
                valueRange = 0f..100f,
                onValueChangeFinished = {
                    // launch some business logic update with the state you hold
                    // viewModel.updateSelectedSliderValue(sliderPosition)
                },
                steps = 1000,
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.secondary,
                    activeTrackColor = MaterialTheme.colorScheme.secondary
                )
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth().height(400.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Ambient Color",
                        color = Color.Black
                    )
                    HarmonyColorPicker(
                        harmonyMode = ColorHarmonyMode.NONE,
                        modifier = Modifier.fillMaxWidth(),
                        color = ambientColor,
                        onColorChanged = { color ->
                            ambientColor = color.toColor()
                        })
                }
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Spot Color",
                        color = Color.Black
                    )
                    HarmonyColorPicker(
                        harmonyMode = ColorHarmonyMode.NONE,
                        modifier = Modifier.fillMaxWidth(),
                        color = spotColor,
                        onColorChanged = { color ->
                            spotColor = color.toColor()
                        })
                }
            }
        }
    }
}