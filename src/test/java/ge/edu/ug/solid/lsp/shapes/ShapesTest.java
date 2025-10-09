package ge.edu.ug.solid.lsp.shapes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShapesTest {
    @Test
    void testShapes() {
        Square square = new Square();
        square.setSide(5);
        validateAreaCalculation(square, 25);
    }

    private void validateAreaCalculation(Shape rectangle, int expectedArea) {
        Assertions.assertEquals(expectedArea, rectangle.area());
    }
}
