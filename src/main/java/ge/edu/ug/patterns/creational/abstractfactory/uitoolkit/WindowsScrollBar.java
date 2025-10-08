package ge.edu.ug.patterns.creational.abstractfactory.uitoolkit;

// Concrete Product
public class WindowsScrollBar implements ScrollBar {
    @Override
    public void render() {
        System.out.println("Windows Scrollbar");
    }
}
