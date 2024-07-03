package org.example

/*
    Represents any 2d geometric figure that is not a point (lines and shapes)
 */
abstract class Figure(points: Array<Point>): Movable {
    // Need to use a backing property to ensure points can be modified while returning a clone publicly
    protected open var _points: Array<Point> = clonePointsArray(points)
    open val points: Array<Point>
        get() {
            return clonePointsArray(_points) // Clone to ensure points
        }

    override fun move(dx: Double, dy: Double) {
        _points.forEach { point -> point.move(dx, dy) }
    }

    fun clonePointsArray(points: Array<Point>): Array<Point> {
        return Array(points.size) { i -> points[i].clone() }
    }
}