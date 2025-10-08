package ge.edu.ug.patterns.creational.abstractfactory.uitoolkit;

// Concrete Factory
public class WinUiToolkitFactory implements UiToolkitFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new WindowsScrollBar();
    }
}
