package ge.edu.ug.patterns.structural.bridge.shapes;

// Abstraction: holds a Color (the bridge) and draws the fill once for every shape.
public abstract class Shape {
    protected Color color;

    protected Shape(Color color) {
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract double area();

    protected abstract String outline();

    public String draw() {
        return outline() + " filled with " + color.name() + " " + color.hex();
    }
}
