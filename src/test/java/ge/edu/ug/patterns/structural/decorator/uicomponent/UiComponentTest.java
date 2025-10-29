package ge.edu.ug.patterns.structural.decorator.uicomponent;

import org.junit.jupiter.api.Test;

class UiComponentTest {

    @Test
    void test() {
        UiComponent component = new DivBorderDecorator(new DivElement());
        System.out.println(component.getDesc());
    }

}
