package pro.devapp.shadowdemo

import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private val paintWithShadow = Paint()
private val frameworkPaintWithShadow = paintWithShadow.asFrameworkPaint()

fun Modifier.coloredShadow(
    color: Color,
    reversed: Boolean = false
) = composed {

    val shadowColor = color.copy(alpha = 0.1f).toArgb()
    val transparent = color.copy(alpha = 0f).toArgb()
    val offsetY = 2.dp
    val offsetX = 4.dp
    val shadowRadius = 8.dp

    this.drawBehind {
        val width = 16.dp.toPx()
        this.drawIntoCanvas {
            frameworkPaintWithShadow.color = transparent

            frameworkPaintWithShadow.setShadowLayer(
                shadowRadius.toPx(),
                offsetX.toPx(),
                offsetY.toPx(),
                shadowColor
            )

            val halfWidth = width / 2
            withTransform({
                if (reversed) {
                    rotate(180f)
                }
                translate(left = -(halfWidth))
            }) {
                clipRect(
                    halfWidth,
                    0f,
                    width * 2,
                    this.size.height
                ) {
                    it.drawRect(
                        halfWidth,
                        0f,
                        1f,
                        this.size.height,
                        paintWithShadow
                    )
                }
            }
        }
    }
}


fun Modifier.coloredAdvancedShadow(
    color: Color,
    alpha: Float = 0.2f,
    borderRadius: Dp = 0.dp,
    shadowRadius: Dp = 20.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp
) = composed {

    val shadowColor = color.copy(alpha = alpha).toArgb()
    val transparent = color.copy(alpha= 0f).toArgb()

    this.drawBehind {

        this.drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            frameworkPaint.color = transparent

            frameworkPaint.setShadowLayer(
                shadowRadius.toPx(),
                offsetX.toPx(),
                offsetY.toPx(),
                shadowColor
            )
            it.drawRoundRect(
                0f,
                0f,
                this.size.width,
                this.size.height,
                borderRadius.toPx(),
                borderRadius.toPx(),
                paint
            )
        }
    }
}