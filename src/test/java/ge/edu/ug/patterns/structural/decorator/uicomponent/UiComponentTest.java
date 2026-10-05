package ge.edu.ug.patterns.structural.decorator.uicomponent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Looks are composed by wrapping, so any combination (and order) is available at runtime.
class UiComponentTest {

    @Test
    void plainDiv() {
        UiComponent component = new DivElement();
        assertEquals("It is rectangular element", component.getDesc());
    }

    @Test
    void divWithBorder() {
        UiComponent component = new DivBorderDecorator(new DivElement());
        assertEquals("It is rectangular element With a nice border", component.getDesc());
    }

    @Test
    void divWithBorderAndShadow() {
        UiComponent component = new DivShadowDecorator(new DivBorderDecorator(new DivElement()));
        assertEquals("It is rectangular element With a nice border With a soft shadow", component.getDesc());
    }

    @Test
    void decoratorsCanBeAddedLater() {
        UiComponent component = new DivElement();
        component = new DivShadowDecorator(component); // e.g. on hover
        assertEquals("It is rectangular element With a soft shadow", component.getDesc());
    }
}
