package ge.edu.ug.patterns.structural.bridge.shapes;

// Refined Abstraction: circle geometry, written once for any Color.
public class Circle extends Shape {
    private final double radius;

    public Circle(double radius, Color color) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    protected String outline() {
        return "Circle(r=" + radius + ")";
    }
}
