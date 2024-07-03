package org.example

abstract class Shape(points: Array<Point>): Figure(points) {
    abstract fun computeArea(): Double
}