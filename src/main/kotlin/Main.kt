package org.example

fun main() {
    println("Hello World!")

    try {
        var tri = Triangle(arrayOf(Point(0.0, 0.0), Point(0.0, 0.0), Point(0.0, 0.0)))
        println(tri.computeArea())
    }
    catch (e: IllegalArgumentException) {
        println(e.message)
    }
}