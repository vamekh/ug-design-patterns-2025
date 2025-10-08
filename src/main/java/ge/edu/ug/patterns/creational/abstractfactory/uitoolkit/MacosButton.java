package ge.edu.ug.patterns.creational.abstractfactory.uitoolkit;

public class MacosButton implements Button{
    @Override
    public void render() {
        System.out.println("MacOS Button");
    }
}
