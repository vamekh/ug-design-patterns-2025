package ge.edu.ug.patterns.structural.decorator.uicomponent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Every look is its own class, chosen at compile time. A div with a border today and
// a shadow added on hover is impossible without creating a new object of a different class.
class UiComponentTest {

    @Test
    void plainDiv() {
        UiComponent component = new DivElement();
        assertEquals("It is rectangular element", component.getDesc());
    }

    @Test
    void divWithBorder() {
        UiComponent component = new DivWithBorder();
        assertEquals("It is rectangular element With a nice border", component.getDesc());
    }

    @Test
    void divWithBorderAndShadow() {
        UiComponent component = new DivWithBorderAndShadow();
        assertEquals("It is rectangular element With a nice border With a soft shadow", component.getDesc());
    }
}
