package ge.edu.ug.patterns.creational.abstractfactory.uitoolkit;

// Concrete Creator
public class MacosUiToolkitFactory implements UiToolkitFactory {
    @Override
    public Button createButton() {
        return new MacosButton();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new MacosScrollbar();
    }
}
