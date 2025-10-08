package ge.edu.ug.patterns.creational.abstractfactory.uitoolkit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UiToolkitTest {
    @Test
    public void testUiToolkit() {
        String environment = "Windows";
        UiToolkit toolkit = new UiToolkit(environment);

        toolkit.createButton().render();
        toolkit.createScrollBar().render();
    }

}
