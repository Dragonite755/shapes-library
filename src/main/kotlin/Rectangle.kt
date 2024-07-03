package org.example

open class Rectangle(points: Array<Point>): Shape(points) {
    // The points can be any two opposite points of the rectangle
    init {
        require(_points.size == 2) { "Invalid number of points for rectangle: ${_points.size} (2 required)" } // A rectangle is represented by exactly two points
        require(computeWidth() != 0.0) { "Rectangle may not have width of 0"}
        require(computeHeight() != 0.0) { "Rectangle may not have height of 0"}
    }

    override fun computeArea(): Double {
        return computeWidth() * computeHeight()
    }

    protected fun computeWidth(): Double {
        return points[1].x - points[0].x
    }

    protected fun computeHeight(): Double {
        return points[1].y - points[0].y
    }
}