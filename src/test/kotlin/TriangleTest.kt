import org.example.Point
import org.example.Triangle
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TriangleTest {
    val delta = 1e-10

    @Test
    fun testInvalidCoordinates() {
        assertFailsWith<IllegalArgumentException> { Triangle(arrayOf(Point(Double.NaN, 34.3), Point(Double.POSITIVE_INFINITY, 34.4), Point(-134.1, 0.01))) }
        assertFailsWith<IllegalArgumentException> { Triangle(arrayOf(Point(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY), Point(-342.3, 34.1), Point(0.0, Double.NEGATIVE_INFINITY))) }
        assertFailsWith<IllegalArgumentException> { Triangle(arrayOf(Point(34.4, Double.NEGATIVE_INFINITY), Point(Double.NaN, 345466.1), Point(Double.NaN, -3466.21))) }
    }

    @Test
    fun testInvalidArea() {
        assertFailsWith<IllegalArgumentException> { Triangle(arrayOf(Point(-2.0, 0.0), Point(0.0, 2.0), Point(2.0, 4.0))) }
        assertFailsWith<IllegalArgumentException> { Triangle(arrayOf(Point(0.0, 0.0), Point(0.0, 0.0), Point(0.0, 0.0))) }
        assertFailsWith<IllegalArgumentException> { Triangle(arrayOf(Point(-100.0, 8.0), Point(0.0, 12.0), Point(100.0, 16.0))) }
    }

    @Test
    fun testArea() {
        assertEquals(Triangle(arrayOf(Point(-2.0, -2.0), Point(-2.0, 2.0), Point(2.0, -2.0))).computeArea(), 8.0, delta)
        assertEquals(
            Triangle(arrayOf(Point(-15.0, -2.0), Point(17.0, -2.0), Point(1.0, 8.0))).computeArea(),
            160.0,
            delta
        )
    }
}