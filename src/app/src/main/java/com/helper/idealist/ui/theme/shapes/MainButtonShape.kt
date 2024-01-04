package com.helper.idealist.ui.theme.shapes

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class MainButtonShape() : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            Path().apply {

                val width = size.width
                val height = size.height

                val widthCellsFactor = width / 20
                val heightCellsFactor = height / 10

                val rectSize = Size(18*widthCellsFactor, 2*heightCellsFactor)

                // Draw figure clockwise

                reset()

                // Top-left hand corner
                arcTo(
                    rect = Rect(
                        Offset(-9 * widthCellsFactor, -heightCellsFactor),
                        rectSize
                    ),
                    startAngleDegrees = 90f,
                    sweepAngleDegrees = -90f,
                    forceMoveTo = false
                )

                lineTo(11*widthCellsFactor, 0f)

                arcTo(
                    rect = Rect(
                        Offset(11 * widthCellsFactor, -heightCellsFactor),
                        rectSize
                    ),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = -90f,
                    forceMoveTo = false
                )

                lineTo(width, 9*heightCellsFactor)

                arcTo(
                    rect = Rect(
                        Offset(11 * widthCellsFactor, 9 * heightCellsFactor),
                        rectSize
                    ),
                    startAngleDegrees = -90f,
                    sweepAngleDegrees = -90f,
                    forceMoveTo = false
                )

                lineTo(9*widthCellsFactor, height)

                arcTo(
                    rect = Rect(
                        Offset(-9 * widthCellsFactor, 9 * heightCellsFactor),
                        rectSize
                    ),
                    startAngleDegrees = 0f,
                    sweepAngleDegrees = -90f,
                    forceMoveTo = false
                )

                lineTo(0f, heightCellsFactor)

                close()
            })
    }
}