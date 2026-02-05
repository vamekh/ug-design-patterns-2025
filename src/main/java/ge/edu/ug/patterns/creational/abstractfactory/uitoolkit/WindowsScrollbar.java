package ge.edu.ug.patterns.creational.abstractfactory.uitoolkit;

// Concrete Product
public class WindowsScrollbar implements ScrollBar {
    @Override
    public void render() {
        System.out.println("Windows Scrollbar");
    }
}
