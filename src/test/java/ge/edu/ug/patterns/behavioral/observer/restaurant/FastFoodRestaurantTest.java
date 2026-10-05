package ge.edu.ug.patterns.behavioral.observer.restaurant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// PROBLEM: the test has to play "the customers' eyes": after every order it calls
// checkScreen() for each person. Jane looks 11 times to get one meal, and anyone
// who is not asked to check would never find out.
class FastFoodRestaurantTest {

    @Test
    void hungryPeopleMustKeepCheckingTheScreen() {
        FastFoodRestaurant restaurant = new FastFoodRestaurant();
        HungryPerson jane = new HungryPerson(10, "Jane", restaurant);
        HungryPerson john = new HungryPerson(14, "John", restaurant);

        for (int i = 0; i < 20; i++) {
            restaurant.markOrderPrepared(i);
            jane.checkScreen();
            john.checkScreen();
        }

        assertTrue(jane.isServed());
        assertTrue(john.isServed());
        assertEquals(11, jane.getChecks());
        assertEquals(15, john.getChecks());
    }
}
