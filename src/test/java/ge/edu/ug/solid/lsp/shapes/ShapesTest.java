package ge.edu.ug.solid.lsp.shapes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ShapesTest {
    // This test demonstrates compliance with Liskov Substitution Principle (LSP)
    // The Square class is designed to be a proper subtype of Shape without breaking
    // the contract. Instead of inheriting from Rectangle (which would violate LSP
    // due to different width/height behavior), Square has its own implementation
    // with a single side parameter, ensuring that objects of the Square type can
    // be used wherever a Shape is expected without breaking the expected behavior.

    @Test
    void testShapes() {
        Rectangle rectangle = new Rectangle(10, 20);
        validateShapeAreaCalculation(rectangle, 200);
        rectangle.setHeight(25);
        validateShapeAreaCalculation(rectangle, 250);
        rectangle.setWidth(15);
        validateShapeAreaCalculation(rectangle, 15*25);
        Square square = new Square(10);
//        We have got no way to get unexpected value of square area, since it doesn't have setWidth() and setHeight()
        validateShapeAreaCalculation(square, 100);
        square.setSide(20);
        validateShapeAreaCalculation(square, 400);
    }

    @Test
    void squareAndRectangleSubstituteForShape() {
        // Client code only knows Shape; both implementations honour its contract
        List<Shape> shapes = List.of(new Rectangle(4, 5), new Square(4));

        Assertions.assertEquals(List.of(20, 16), shapes.stream().map(Shape::area).toList());
        Assertions.assertEquals(36, shapes.stream().mapToInt(Shape::area).sum());
    }

    private void validateShapeAreaCalculation(Shape shape, int expectedValue) {
        Assertions.assertEquals(expectedValue, shape.area());
    }
}
