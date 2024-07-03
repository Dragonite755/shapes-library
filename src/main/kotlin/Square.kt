package org.example

class Square(points: Array<Point>): Rectangle(points) {
    init {
        val width: Double = computeWidth()
        val height: Double = computeHeight()
        require(width == height) { "Width (${width}) must be equivalent to height (${height}) for a square" }
    }
}