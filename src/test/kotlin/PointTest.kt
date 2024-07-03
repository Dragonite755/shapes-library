import org.example.Point
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotSame

class PointTest {
    var delta = 1e-10

    @Test
    fun testInvalidCoordinates() {
        assertFailsWith<IllegalArgumentException> { Point(0.0, Double.NaN) }
        assertFailsWith<IllegalArgumentException> { Point(Double.NaN, 3.45) }
        assertFailsWith<IllegalArgumentException> { Point(Double.POSITIVE_INFINITY, 3.0) }
        assertFailsWith<IllegalArgumentException> { Point(-200.3212, Double.NEGATIVE_INFINITY) }
    }

    @Test
    fun testClone() {
        val points = arrayOf(Point(1.0, -2.0), Point(13.45, 10.01), Point(-12553.4234121, 1414141.01414))
        for (point: Point in points) {
            val clone = point.clone()
            assertNotSame(point, clone)
            assertEquals(point.x, clone.x, delta)
            assertEquals(point.y, clone.y, delta)
        }
    }

    @Test
    fun testInvalidMove() {
        assertFailsWith<IllegalArgumentException> { Point(1.0, -2.0).move(0.0, Double.NaN) }
        assertFailsWith<IllegalArgumentException> { Point(13.45, 10.01).move(Double.POSITIVE_INFINITY, 3.0) }
        assertFailsWith<IllegalArgumentException> { Point(13234.415, -310.011).move(-1011.123, Double.NEGATIVE_INFINITY) }
    }

    @Test
    fun testMove() {
        var point = Point(4.3, -1.2)
        point.move(2.0, 3.0)
        assertEquals(6.3, point.x, delta)
        assertEquals(1.8, point.y, delta)

        point = Point(123.23, 0.0)
        point.move(-135.3, 5.7)
        assertEquals(-12.07, point.x, delta)
        assertEquals(5.7, point.y, delta)
    }
}