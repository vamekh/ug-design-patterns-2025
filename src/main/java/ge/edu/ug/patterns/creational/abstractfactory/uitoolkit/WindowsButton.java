package ge.edu.ug.patterns.creational.abstractfactory.uitoolkit;

// Concrete Product
public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Windows Button");
    }
}
