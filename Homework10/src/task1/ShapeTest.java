package task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeTest
{

    @Test
    void testTriangleArea()
    {
        Triangle triangle = new Triangle(10, 5);
        assertEquals(25.0, triangle.getArea(), 0.001);
    }

    @Test
    void testRectangleArea()
    {
        Rectangle rectangle = new Rectangle(4, 6);
        assertEquals(24.0, rectangle.getArea(), 0.001);
    }

    @Test
    void testSquareArea()
    {
        Square square = new Square(5);
        assertEquals(25.0, square.getArea(), 0.001);
    }

    @Test
    void testRhombusArea()
    {
        Rhombus rhombus = new Rhombus(8, 6);
        assertEquals(24.0, rhombus.getArea(), 0.001);
    }
}

