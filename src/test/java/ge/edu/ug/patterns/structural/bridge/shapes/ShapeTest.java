package ge.edu.ug.patterns.structural.bridge.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// PROBLEM: every combination of shape and color is its own class, so the tests
// (and the code) repeat the same checks for RedCircle, BlueCircle, RedSquare and BlueSquare.
// There is no common type, so you cannot keep "any shape" in a list or recolor a shape.
class ShapeTest {

    @Test
    void redCircle() {
        RedCircle circle = new RedCircle(2);

        assertEquals(Math.PI * 4, circle.area(), 1e-9);
        assertEquals("Circle(r=2.0) filled with red #FF0000", circle.draw());
    }

    @Test
    void blueCircle() {
        BlueCircle circle = new BlueCircle(1);

        assertEquals(Math.PI, circle.area(), 1e-9);
        assertEquals("Circle(r=1.0) filled with blue #0000FF", circle.draw());
    }

    @Test
    void redSquare() {
        RedSquare square = new RedSquare(3);

        assertEquals(9, square.area(), 1e-9);
        assertEquals("Square(side=3.0) filled with red #FF0000", square.draw());
    }

    @Test
    void blueSquare() {
        BlueSquare square = new BlueSquare(4);

        assertEquals(16, square.area(), 1e-9);
        assertEquals("Square(side=4.0) filled with blue #0000FF", square.draw());
    }
}
