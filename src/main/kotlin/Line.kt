package org.example

class Line(points: Array<Point>): Movable {
    // Need to use a backing property to ensure points can be modified while returning a clone publicly
    private var _points: Array<Point> = clonePointsArray(points)
    val points: Array<Point>
        get() {
            return clonePointsArray(_points) // Clone to ensure points
        }

    override fun move(dx: Double, dy: Double) {
        _points.forEach { point -> point.move(dx, dy) }
        _points.forEach { point -> println("Moved: ${point.x} ${point.y}") }
    }
}