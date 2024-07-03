package org.example

interface Movable {
    /*
        Translates an object in two-dimensional space

        dx: Change in x-coordinate
        dy: Change in y-coordinate
     */
    fun move(dx: Double, dy: Double)
}