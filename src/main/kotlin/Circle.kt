package org.example

class Circle(center: Point, radius: Double): Ellipse(center, arrayOf(radius, radius)) {
    val radius: Double = radius
}