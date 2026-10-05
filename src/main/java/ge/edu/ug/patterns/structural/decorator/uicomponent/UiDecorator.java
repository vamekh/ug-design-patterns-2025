package ge.edu.ug.patterns.structural.decorator.uicomponent;

// Base Decorator: holds the wrapped component
public abstract class UiDecorator implements UiComponent {
    protected final UiComponent component;

    public UiDecorator(UiComponent component) {
        this.component = component;
    }
}
