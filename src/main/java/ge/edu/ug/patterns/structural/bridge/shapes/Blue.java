package ge.edu.ug.patterns.structural.bridge.shapes;

// Concrete Implementor
public class Blue implements Color {
    @Override
    public String name() {
        return "blue";
    }

    @Override
    public String hex() {
        return "#0000FF";
    }
}
