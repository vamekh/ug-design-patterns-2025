package ge.edu.ug.patterns.creational.abstractfactory.uitoolkit;

// Concrete Product
public class MacosScrollbar implements ScrollBar {
    @Override
    public void render() {
        System.out.println("MacOS Scrollbar");
    }
}
