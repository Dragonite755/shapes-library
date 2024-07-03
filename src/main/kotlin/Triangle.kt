package org.example

import kotlin.math.abs

class Triangle(points: Array<Point>): Shape(points) {
    init {
        require(_points.size == 3) { "Invalid number of points provided for a triangle: ${_points.size} (3 required)"}
        require(computeArea() != 0.0) { "Triangle cannot have area of 0" }
    }

    // Utilizes the shoelace formula to calculate the area of a triangle from its vertices
    override fun computeArea(): Double {
        return abs(points[0].x * (points[1].y - points[2].y) + points[1].x * (points[2].y - points[0].y) + points[2].x * (points[0].y - points[1].y)) / 2.0
    }
}