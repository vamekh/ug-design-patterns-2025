package ge.edu.ug.patterns.structural.bridge.shapes;

public class BlueCircle {
    private final double radius;

    public BlueCircle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public String draw() {
        return "Circle(r=" + radius + ") filled with blue #0000FF";
    }
}
