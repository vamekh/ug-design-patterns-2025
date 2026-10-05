package ge.edu.ug.patterns.structural.decorator.uicomponent;

// Concrete Decorator
public class DivBorderDecorator extends UiDecorator {
    public DivBorderDecorator(UiComponent component) {
        super(component);
    }

    @Override
    public String getDesc() {
        return component.getDesc() + " With a nice border";
    }
}
