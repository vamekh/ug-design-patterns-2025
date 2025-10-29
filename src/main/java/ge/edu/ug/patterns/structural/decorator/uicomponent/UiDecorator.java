package ge.edu.ug.patterns.structural.decorator.uicomponent;

public abstract class UiDecorator implements UiComponent {
    protected UiComponent component;

    public UiDecorator(UiComponent component) {
        this.component = component;
    }
}
