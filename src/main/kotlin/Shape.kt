package org.example

abstract class Shape: Movable {
    // Need to use a backing property to ensure points can be modified while returning a clone publicly
    abstract var _points: Array<Point>
    val points: Array<Point>
        get() {
            return clonePointsArray(_points) // Clone to ensure points
        }

    abstract fun computeArea(): Double

    override fun move(dx: Double, dy: Double) {
        _points.forEach { point -> point.move(dx, dy) }
        _points.forEach { point -> println("Moved: ${point.x} ${point.y}") }
    }
}