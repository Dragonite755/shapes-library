import org.example.Line
import org.example.Point
import kotlin.test.Test
import kotlin.test.assertFailsWith

class LineTest {
    @Test
    fun testInvalidCoordinates() {
        assertFailsWith<IllegalArgumentException> { Line(arrayOf(Point(Double.NaN, 34.3), Point(-134.1, 0.01))) }
        assertFailsWith<IllegalArgumentException> { Line(arrayOf(Point(-342.3, 34.1), Point(0.0, Double.NEGATIVE_INFINITY))) }
        assertFailsWith<IllegalArgumentException> { Line(arrayOf(Point(34.4, Double.NEGATIVE_INFINITY), Point(Double.NaN, 345466.1))) }
    }

    @Test
    fun testInvalidLength() {
        assertFailsWith<IllegalArgumentException> { Line(arrayOf(Point(0.0, 3.0), Point(0.0, 3.0))) }
        assertFailsWith<IllegalArgumentException> { Line(arrayOf(Point(-12.0, 2.434), Point(-12.0, 2.434))) }
        assertFailsWith<IllegalArgumentException> { Line(arrayOf(Point(-334314.1, 111.11), Point(-334314.1, 111.11))) }
    }

    @Test
    fun testInvalidNumberOfPoints() {
        assertFailsWith<IllegalArgumentException> { Line(arrayOf<Point>()) }
        assertFailsWith<IllegalArgumentException> { Line(arrayOf(Point(0.0, 0.0))) }
        assertFailsWith<IllegalArgumentException> { Line(arrayOf(Point(0.0, 0.0), Point(0.0, 0.0), Point(0.0, 0.0))) }
        assertFailsWith<IllegalArgumentException> { Line(arrayOf(Point(0.0, 0.0), Point(0.0, 0.0), Point(0.0, 0.0), Point(0.0, 0.0))) }
    }
}