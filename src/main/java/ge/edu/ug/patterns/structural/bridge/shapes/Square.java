package ge.edu.ug.patterns.structural.bridge.shapes;

// Refined Abstraction: square geometry, written once for any Color.
public class Square extends Shape {
    private final double side;

    public Square(double side, Color color) {
        super(color);
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    protected String outline() {
        return "Square(side=" + side + ")";
    }
}
