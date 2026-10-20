package ge.edu.ug.patterns.structural.bridge.shapes;

// Implementor: what every color provides; shapes only talk to this interface.
public interface Color {
    String name();

    String hex();
}
