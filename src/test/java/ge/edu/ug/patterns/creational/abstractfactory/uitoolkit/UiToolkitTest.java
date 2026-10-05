package ge.edu.ug.patterns.creational.abstractfactory.uitoolkit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UiToolkitTest {
    @Test
    public void testUiToolkit() {
        UiToolkitFactory toolkit = new WinUiToolkitFactory();
        Application app = new Application(toolkit);

        app.render();
        assertInstanceOf(WindowsButton.class, app.getButton());
        assertInstanceOf(WindowsScrollBar.class, app.getScrollBar());
    }

    @Test
    public void testMacosUiToolkit() {
        UiToolkitFactory toolkit = new MacosUiToolkitFactory();
        Application app = new Application(toolkit);

        app.render();
        assertInstanceOf(MacosButton.class, app.getButton());
        assertInstanceOf(MacosScrollBar.class, app.getScrollBar());
    }

}
