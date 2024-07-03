package org.example

class Point(x: Double, y: Double): Movable {
    var x: Double = x
        private set
    var y: Double = y
        private set

    init {
        // Ensure that coordinates are neither NaN nor infinite
        require(x.isFinite()) { "Invalid value for x: $x" }
        require(y.isFinite()) { "Invalid value for y: $y" }
    }

    fun clone(): Point {
        return Point(x, y)
    }

    override fun move(dx: Double, dy: Double) {
        require(dx.isFinite() && dy.isFinite()) { "Invalid deltas provided: ${dx}, ${dy}" }

        x += dx
        y += dy
    }
}