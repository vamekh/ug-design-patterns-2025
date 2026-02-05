package ge.edu.ug.patterns.creational.abstractfactory.uitoolkit;

// Concrete Creator
public class WinUiToolkitFactory implements UiToolkitFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public ScrollBar createScrollBar() {
        return new WindowsScrollbar();
    }
}
