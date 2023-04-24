package pro.devapp.shadowdemo

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
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
import androidx.compose.ui.unit.dp
import com.godaddy.android.colorpicker.harmony.ColorHarmonyMode
import com.godaddy.android.colorpicker.harmony.HarmonyColorPicker

@Composable
fun CustomAdvancedShadow() {
    var alpha by remember { mutableStateOf(0.2f) }
    var borderRadius by remember { mutableStateOf(0f) }
    var shadowRadius by remember { mutableStateOf(20f) }
    var offsetY by remember { mutableStateOf(0f) }
    var offsetX by remember { mutableStateOf(0f) }

    var shadowColor by remember {
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
        ) {

            Text(
                text = "Custom advanced shadow",
                color = Color.Black
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                ) {
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Box(
                            modifier = Modifier
                                .coloredAdvancedShadow(
                                    color = shadowColor,
                                    alpha = alpha,
                                    borderRadius = borderRadius.dp,
                                    shadowRadius = shadowRadius.dp,
                                    offsetY = offsetY.dp,
                                    offsetX = offsetX.dp
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
                                .coloredAdvancedShadow(
                                    color = shadowColor,
                                    alpha = alpha,
                                    borderRadius = borderRadius.dp,
                                    shadowRadius = shadowRadius.dp,
                                    offsetY = offsetY.dp,
                                    offsetX = offsetX.dp
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
                                .coloredAdvancedShadow(
                                    color = shadowColor,
                                    alpha = alpha,
                                    borderRadius = borderRadius.dp,
                                    shadowRadius = shadowRadius.dp,
                                    offsetY = offsetY.dp,
                                    offsetX = offsetX.dp
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
                Row(modifier = Modifier
                    .fillMaxWidth()
                ) {
                    Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                        Box(
                            modifier = Modifier
                                .coloredAdvancedShadow(
                                    color = shadowColor,
                                    alpha = alpha,
                                    borderRadius = borderRadius.dp,
                                    shadowRadius = shadowRadius.dp,
                                    offsetY = offsetY.dp,
                                    offsetX = offsetX.dp
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
                                .coloredAdvancedShadow(
                                    color = shadowColor,
                                    alpha = alpha,
                                    borderRadius = borderRadius.dp,
                                    shadowRadius = shadowRadius.dp,
                                    offsetY = offsetY.dp,
                                    offsetX = offsetX.dp
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
                                .coloredAdvancedShadow(
                                    color = shadowColor,
                                    alpha = alpha,
                                    borderRadius = borderRadius.dp,
                                    shadowRadius = shadowRadius.dp,
                                    offsetY = offsetY.dp,
                                    offsetX = offsetX.dp
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
                text = "alpha ${alpha}",
                color = Color.Black
            )
            Slider(
                value = alpha,
                onValueChange = { alpha = it },
                valueRange = 0f..1f,
                onValueChangeFinished = {
                },
                steps = 1000,
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.secondary,
                    activeTrackColor = MaterialTheme.colorScheme.secondary
                )
            )

            Text(
                text = "borderRadius ${borderRadius}",
                color = Color.Black
            )
            Slider(
                value = borderRadius,
                onValueChange = { borderRadius = it },
                valueRange = 0f..10f,
                onValueChangeFinished = {
                },
                steps = 1000,
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.secondary,
                    activeTrackColor = MaterialTheme.colorScheme.secondary
                )
            )

            Text(
                text = "shadowRadius ${shadowRadius}",
                color = Color.Black
            )
            Slider(
                value = shadowRadius,
                onValueChange = { shadowRadius = it },
                valueRange = 0f..100f,
                onValueChangeFinished = {
                },
                steps = 1000,
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.secondary,
                    activeTrackColor = MaterialTheme.colorScheme.secondary
                )
            )

            Text(
                text = "offsetY ${offsetY}",
                color = Color.Black
            )
            Slider(
                value = offsetY,
                onValueChange = { offsetY = it },
                valueRange = -100f..100f,
                onValueChangeFinished = {
                },
                steps = 1000,
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.secondary,
                    activeTrackColor = MaterialTheme.colorScheme.secondary
                )
            )

            Text(
                text = "offsetX ${offsetX}",
                color = Color.Black
            )
            Slider(
                value = offsetX,
                onValueChange = { offsetX = it },
                valueRange = -100f..100f,
                onValueChangeFinished = {
                },
                steps = 1000,
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.secondary,
                    activeTrackColor = MaterialTheme.colorScheme.secondary
                )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
            ){
                Column(
                    modifier = Modifier.weight(1f).height(500.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Color",
                        color = Color.Black
                    )
                    HarmonyColorPicker(
                        harmonyMode = ColorHarmonyMode.NONE,
                        modifier = Modifier.fillMaxWidth().height(400.dp),
                        color = shadowColor,
                        onColorChanged = { color ->
                            shadowColor = color.toColor()
                        })
                }
            }
        }
    }
}