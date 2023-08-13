package com.helper.idealist.ui.shapes

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class MainButtonShape(val startPosition : Int) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            Path().apply {
                val width = size.width
                val height = size.height

                // Lets draw an imaginative cloud

                // Draw main cloud (left-right corners)

                // Left side
                arcTo(
                    rect = Rect(
                        Offset(0f, height/5),
                        Size(width/6, 3*height/5) // width/6 comes from 2*width/12
                    ),
                    startAngleDegrees = 90f,
                    sweepAngleDegrees = 180f,
                    forceMoveTo = true
                )
                // Right side
                arcTo(
                    rect = Rect(
                        Offset(5*width/6, height/5), // 5*width/6 comes from 10*width/12
                        Size(width/6, 3*height/5) // width/6 comes from 2*width/12
                    ),
                    startAngleDegrees = 90f,
                    sweepAngleDegrees = -180f,
                    forceMoveTo = true
                )

                // From now going circle by circle from left to right (Top)
                for (i in 0..3){
                    arcTo(
                        rect = Rect(
                            Offset((5*i+2)*width/24,0f), // width/12 comes from width/6/2
                            Size(5*width/24, 2*height/5)
                        ),
                        startAngleDegrees = 180f,
                        sweepAngleDegrees = 180f,
                        forceMoveTo = true
                    )
                    arcTo(
                        rect = Rect(
                            Offset((5*i+2)*width/24,3*height/5), // width/12 comes from width/6/2
                            Size(5*width/24, 2*height/5)
                        ),
                        startAngleDegrees = 0f,
                        sweepAngleDegrees = 180f,
                        forceMoveTo = true
                    )
                }
                // Fill the remaining space
                addRect(
                    rect = Rect(
                        Offset(width/12, height/5),
                        Size(5*width/6, 3*height/5)
                    )
                )

                // TODO: Draw circles in such way this cloud
                // looks like a comic's speech bubble
                close()
            })
    }
}