package ge.edu.ug.patterns.structural.decorator.uicomponent;

// Concrete Decorator
public class DivShadowDecorator extends UiDecorator {
    public DivShadowDecorator(UiComponent component) {
        super(component);
    }

    @Override
    public String getDesc() {
        return component.getDesc() + " With a soft shadow";
    }
}
