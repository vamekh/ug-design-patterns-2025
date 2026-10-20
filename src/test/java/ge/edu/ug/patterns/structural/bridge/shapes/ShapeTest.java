package ge.edu.ug.patterns.structural.bridge.shapes;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    void redCircle() {
        Shape circle = new Circle(2, new Red());

        assertEquals(Math.PI * 4, circle.area(), 1e-9);
        assertEquals("Circle(r=2.0) filled with red #FF0000", circle.draw());
    }

    @Test
    void blueCircle() {
        Shape circle = new Circle(1, new Blue());

        assertEquals(Math.PI, circle.area(), 1e-9);
        assertEquals("Circle(r=1.0) filled with blue #0000FF", circle.draw());
    }

    @Test
    void redSquare() {
        Shape square = new Square(3, new Red());

        assertEquals(9, square.area(), 1e-9);
        assertEquals("Square(side=3.0) filled with red #FF0000", square.draw());
    }

    @Test
    void blueSquare() {
        Shape square = new Square(4, new Blue());

        assertEquals(16, square.area(), 1e-9);
        assertEquals("Square(side=4.0) filled with blue #0000FF", square.draw());
    }

    @Test
    void newColorWorksWithEveryShape() {
        // Green is one new class; both shapes use it with no other change.
        List<Shape> shapes = List.of(new Circle(1, new Green()), new Square(2, new Green()));

        assertEquals("Circle(r=1.0) filled with green #00FF00", shapes.get(0).draw());
        assertEquals("Square(side=2.0) filled with green #00FF00", shapes.get(1).draw());
    }

    @Test
    void colorCanBeSwappedAtRuntime() {
        Shape square = new Square(1, new Red());
        square.setColor(new Blue());

        assertEquals("Square(side=1.0) filled with blue #0000FF", square.draw());
    }
}
