package ge.edu.ug.patterns.structural.bridge.shapes;

// Concrete Implementor
public class Red implements Color {
    @Override
    public String name() {
        return "red";
    }

    @Override
    public String hex() {
        return "#FF0000";
    }
}
