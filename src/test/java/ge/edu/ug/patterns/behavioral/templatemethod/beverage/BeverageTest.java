package ge.edu.ug.patterns.behavioral.templatemethod.beverage;

import org.junit.jupiter.api.Test;

class BeverageTest {

    @Test
    void teaFollowsTheRecipe() {
        new Tea().prepare();
        new Coffee().prepare();
    }
}
