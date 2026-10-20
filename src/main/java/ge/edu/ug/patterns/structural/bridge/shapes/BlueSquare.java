package ge.edu.ug.patterns.structural.bridge.shapes;

public class BlueSquare {
    private final double side;

    public BlueSquare(double side) {
        this.side = side;
    }

    public double area() {
        return side * side;
    }

    public String draw() {
        return "Square(side=" + side + ") filled with blue #0000FF";
    }
}
