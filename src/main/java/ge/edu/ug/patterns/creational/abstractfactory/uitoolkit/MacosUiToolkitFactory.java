package ge.edu.ug.patterns.creational.abstractfactory.uitoolkit;

// Concrete Factory
public class MacosUiToolkitFactory implements UiToolkitFactory {
    @Override
    public Button createButton() {
        return new MacosButton();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new MacosScrollBar();
    }
}
