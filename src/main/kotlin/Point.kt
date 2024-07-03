package org.example

class Point(_x: Double, _y: Double): Movable {
    var x: Double
        private set
    var y: Double
        private set

    init {
        x = _x
        y = _y
    }

    fun clone(): Point {
        return Point(x, y)
    }

    override fun move(dx: Double, dy: Double) {
        x += dx
        y += dy
    }
}