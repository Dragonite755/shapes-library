package org.example

import kotlin.math.pow
import kotlin.math.sqrt

class Line(points: Array<Point>): Movable {
    // Need to use a backing property to ensure points can be modified while returning a clone publicly
    private var _points: Array<Point> = clonePointsArray(points)
    val points: Array<Point>
        get() {
            return clonePointsArray(_points) // Clone to ensure points
        }

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

    override fun move(dx: Double, dy: Double) {
        _points.forEach { point -> point.move(dx, dy) }
    }

    // Compute the horizontal displacement between the points
    fun computeHorizontal(): Double {
        return _points[1].x - _points[0].x
    }

    // Compute the vertical displacement between the points
    fun computeVertical(): Double {
        return _points[1].y - _points[0].y
    }
}