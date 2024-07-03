package org.example

import kotlin.math.pow
import kotlin.math.sqrt

class Line(points: Array<Point>): Figure(points) {
    init {
        require(_points.size == 2) { "Invalid number of points for line: ${_points.size} (2 required)" } // A line must have exactly two points
        val length = computeLength()
        require(length != 0.0) { "Line cannot be of length 0"}
    }

    fun computeSlope(): Double {
        return computeVertical() / computeHorizontal()
    }

    fun computeLength(): Double {
        return sqrt(computeHorizontal().pow(2) + computeVertical().pow(2))
    }

    // Compute the horizontal displacement between the points
    private fun computeHorizontal(): Double {
        return _points[1].x - _points[0].x
    }

    // Compute the vertical displacement between the points
    private fun computeVertical(): Double {
        return _points[1].y - _points[0].y
    }
}