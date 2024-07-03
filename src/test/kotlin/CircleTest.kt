import org.example.Circle
import org.example.Point
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CircleTest {
    @Test
    fun testInvalidRadius() {
        assertFailsWith<IllegalArgumentException> { Circle(Point(-3.0, 4.1), 0.0) }
        assertFailsWith<IllegalArgumentException> { Circle(Point(-3.0, 4.1), -32.1) }
        assertFailsWith<IllegalArgumentException> { Circle(Point(-3.0, 4.1), -55.5) }
        assertFailsWith<IllegalArgumentException> { Circle(Point(-3.0, 4.1), 0.0) }
    }

    @Test
    fun testArea() {
        val delta = 1e-3
        assertEquals(Circle(Point(0.0, 0.0), 4.0).computeArea(), 50.2655, delta)
        assertEquals(Circle(Point(0.0, 0.0), 23.1).computeArea(), 1676.3852558, delta)
    }
}