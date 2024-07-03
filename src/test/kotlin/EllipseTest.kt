import org.example.Ellipse
import org.example.Point
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class EllipseTest {
    @Test
    fun testInvalidRadii() {
        assertFailsWith<IllegalArgumentException> { Ellipse(Point(-3.0, 4.1), arrayOf(0.0, 3.2)) }
        assertFailsWith<IllegalArgumentException> { Ellipse(Point(-3.0, 4.1), arrayOf(-32.1, 33.2)) }
        assertFailsWith<IllegalArgumentException> { Ellipse(Point(-3.0, 4.1), arrayOf(3.1, -55.5)) }
        assertFailsWith<IllegalArgumentException> { Ellipse(Point(-3.0, 4.1), arrayOf(1.2, 0.0)) }
    }

    @Test
    fun testInvalidNumberOfRadii() {
        assertFailsWith<IllegalArgumentException> { Ellipse(Point(0.0, 0.0), arrayOf<Double>()) }
        assertFailsWith<IllegalArgumentException> { Ellipse(Point(0.0, 0.0), arrayOf(1.0)) }
        assertFailsWith<IllegalArgumentException> { Ellipse(Point(0.0, 0.0), arrayOf(1.0, 1.0, 1.0)) }
        assertFailsWith<IllegalArgumentException> { Ellipse(Point(0.0, 0.0), arrayOf(1.0, 2.3, 4.1, 1.1)) }
        assertFailsWith<IllegalArgumentException> { Ellipse(Point(0.0, 0.0), arrayOf(1.0, 2.3, 3.3, 4.4, 5.5)) }
    }

    @Test
    fun testArea() {
        val delta = 1e-10
        assertEquals(Ellipse(Point(0.0, 0.0), arrayOf(4.0, 5.0)).computeArea(), 62.83185, delta)
        assertEquals(Ellipse(Point(0.0, 0.0), arrayOf(23.1, 55.0)).computeArea(), 3991.3934, delta)
    }
}