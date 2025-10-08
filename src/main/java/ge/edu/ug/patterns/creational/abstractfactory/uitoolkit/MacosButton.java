package ge.edu.ug.patterns.creational.abstractfactory.uitoolkit;

// Concrete Product
public class MacosButton implements Button {
    @Override
    public void render() {
        System.out.println("MacOS Button");
    }
}
