package ge.edu.ug.patterns.behavioral.templatemethod.beverage;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BeverageTest {

    @Test
    void teaFollowsTheRecipe() {
        List<String> steps = new Tea().prepare();

        assertEquals(List.of("Boiling water", "Steeping the tea", "Pouring into cup", "Adding lemon"), steps);
    }

    @Test
    void coffeeFollowsTheSameRecipe() {
        List<String> steps = new Coffee().prepare();

        assertEquals(List.of("Boiling water", "Dripping coffee through filter", "Pouring into cup", "Adding sugar and milk"), steps);
    }

    @Test
    void blackCoffeeSkipsCondimentsThroughTheHook() {
        List<String> steps = new Coffee(false).prepare();

        assertEquals(List.of("Boiling water", "Dripping coffee through filter", "Pouring into cup"), steps);
    }

    @Test
    void templateMethodCannotBeOverridden() throws NoSuchMethodException {
        int modifiers = HotBeverage.class.getMethod("prepare").getModifiers();

        assertTrue(Modifier.isFinal(modifiers));
    }
}
