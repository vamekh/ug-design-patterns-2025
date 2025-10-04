package ge.edu.ug.solid.lsp.shapes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShapesTest {
    // This test demonstrates a violation of Liskov Substitution Principle (LSP)
    // Square class inherits from Rectangle but changes its behavior:
    // Setting different width and height on a Square breaks the Rectangle contract
    // because Square forces width and height to be equal

    @Test
    void testShapes() {
        Rectangle rectangle = new Square();
        validateAreaCalculation(rectangle);
    }

    private void validateAreaCalculation(Rectangle rectangle) {
        rectangle.setWidth(10);
        rectangle.setHeight(20);
        Assertions.assertEquals(200, rectangle.area());
    }
}
