package ge.edu.ug.patterns.structural.decorator.uicomponent;

public class DivBorderDecorator extends UiDecorator {
    public DivBorderDecorator(UiComponent component) {
        super(component);
    }

    @Override
    public String getDesc() {
        return super.component.getDesc() + " With a nice border";
    }
}
