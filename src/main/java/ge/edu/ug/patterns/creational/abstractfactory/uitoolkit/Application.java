package ge.edu.ug.patterns.creational.abstractfactory.uitoolkit;

// Client: knows only the abstract factory and the abstract products
public class Application {
    private final Button button;
    private final ScrollBar scrollBar;

    public Application(UiToolkitFactory factory) {
        this.button = factory.createButton();
        this.scrollBar = factory.createScrollBar();
    }

    public void render() {
        button.render();
        scrollBar.render();
    }

    public Button getButton() {
        return button;
    }

    public ScrollBar getScrollBar() {
        return scrollBar;
    }
}
