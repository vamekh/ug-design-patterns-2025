package ge.edu.ug.patterns.creational.abstractfactory.uitoolkit;

import org.junit.jupiter.api.Test;

class UiToolkitTest {
    @Test
    public void testUiToolkit() {
        WinUiToolkitFactory toolkit = new WinUiToolkitFactory();

        toolkit.createButton().render();
        toolkit.createScrollBar().render();
    }

}
