package ge.edu.ug.patterns.structural.bridge.shapes;

// PROBLEM: one class per (shape x color) pair: RedCircle, BlueCircle, RedSquare, BlueSquare.
// The circle geometry is copied into both circles, the square geometry into both squares,
// and the color code ("red", "#FF0000") into every class of that color.
// A new color (Green) needs one class per shape; a new shape (Triangle) needs one per color (n x m).
public class RedCircle {
    private final double radius;

    public RedCircle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public String draw() {
        return "Circle(r=" + radius + ") filled with red #FF0000";
    }
}
