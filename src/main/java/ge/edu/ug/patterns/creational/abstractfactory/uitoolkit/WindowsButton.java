package ge.edu.ug.patterns.creational.abstractfactory.uitoolkit;

public class WindowsButton implements Button{
    @Override
    public void render() {
        System.out.println("Windows Button");
    }
}
