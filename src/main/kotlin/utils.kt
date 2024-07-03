package org.example

/*
    Clones a list of points
 */
fun clonePointsArray(points: Array<Point>): Array<Point> {
    return Array(points.size) { i -> points[i].clone() }
}