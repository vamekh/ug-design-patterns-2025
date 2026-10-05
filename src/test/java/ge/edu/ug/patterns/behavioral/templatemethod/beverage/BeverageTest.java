package ge.edu.ug.patterns.behavioral.templatemethod.beverage;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

// PROBLEM: the same recipe lives in two prepare() methods. These tests pin down
// how the copies drifted: Coffee skips "Pouring into cup", and only Coffee
// supports "no condiments" because the option was added to one copy only.
class BeverageTest {

    @Test
    void teaFollowsTheRecipe() {
        List<String> steps = new Tea().prepare();

        assertEquals(List.of("Boiling water", "Steeping the tea", "Pouring into cup", "Adding lemon"), steps);
    }

    @Test
    void coffeeDriftedFromTheRecipe() {
        List<String> steps = new Coffee().prepare();

        assertEquals(List.of("Boiling water", "Dripping coffee through filter", "Adding sugar and milk"), steps);
        assertFalse(steps.contains("Pouring into cup"), "the copy-pasted recipe forgot a step");
    }

    @Test
    void blackCoffeeSkipsCondiments() {
        List<String> steps = new Coffee(false).prepare();

        assertEquals(List.of("Boiling water", "Dripping coffee through filter"), steps);
    }
}
