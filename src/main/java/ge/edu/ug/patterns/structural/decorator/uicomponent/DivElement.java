package ge.edu.ug.patterns.structural.decorator.uicomponent;

// Each visual extra is baked in through inheritance: DivWithBorder, DivWithShadow and
// DivWithBorderAndShadow. The border/shadow text is duplicated across classes, and a third
// extra (rounded corners) would need 4 more subclasses to cover every combination.
public class DivElement implements UiComponent {
    @Override
    public String getDesc() {
        return "It is rectangular element";
    }
}
