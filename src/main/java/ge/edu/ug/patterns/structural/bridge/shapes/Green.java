package ge.edu.ug.patterns.structural.bridge.shapes;

// Concrete Implementor
public class Green implements Color {
    @Override
    public String name() {
        return "green";
    }

    @Override
    public String hex() {
        return "#00FF00";
    }
}
