package ge.edu.ug.patterns.structural.bridge.shapes;

public class RedSquare {
    private final double side;

    public RedSquare(double side) {
        this.side = side;
    }

    public double area() {
        return side * side;
    }

    public String draw() {
        return "Square(side=" + side + ") filled with red #FF0000";
    }
}
