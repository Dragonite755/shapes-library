package org.example

import kotlin.math.PI

open class Ellipse(center: Point, radii: Array<Double>): Shape(arrayOf(center)) {
    val radii: Array<Double> = radii
    val center: Point
        get() {
            return _points[0]
        }

    init {
        require(radii.size == 2) {"Invalid number of radii provided for ellipse: ${radii.size} (2 required)"}
        radii.forEach { radius -> require(radius.isFinite() && radius > 0) {"Invalid radius provided: ${radius}"} }
        // Checking that both radii are positive is enough to ensure that area is not zero
    }

    override fun computeArea(): Double {
        return PI * radii[0] * radii[1]
    }
}