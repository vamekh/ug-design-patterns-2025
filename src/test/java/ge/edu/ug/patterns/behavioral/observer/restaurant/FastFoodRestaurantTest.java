package ge.edu.ug.patterns.behavioral.observer.restaurant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FastFoodRestaurantTest {

    @Test
    void kitchenNotifiesHungryPeople() {
        FastFoodRestaurant restaurant = new FastFoodRestaurant();
        HungryPerson jane = new HungryPerson(10, "Jane", restaurant);
        HungryPerson john = new HungryPerson(14, "John", restaurant);
        restaurant.subscribe(jane);
        restaurant.subscribe(john);

        for (int i = 0; i < 20; i++) {
            restaurant.markOrderPrepared(i);
        }

        assertTrue(jane.isServed());
        assertTrue(john.isServed());
        assertEquals(0, restaurant.getObserverCount(), "served people unsubscribe themselves");
    }

    @Test
    void unsubscribingDuringNotificationDoesNotBreakTheLoop() {
        FastFoodRestaurant restaurant = new FastFoodRestaurant();
        HungryPerson jane = new HungryPerson(10, "Jane", restaurant);
        HungryPerson john = new HungryPerson(14, "John", restaurant);
        HungryPerson mike = new HungryPerson(20, "Mike", restaurant);
        restaurant.subscribe(jane);
        restaurant.subscribe(john);
        restaurant.subscribe(mike);

        // Jane unsubscribes in the middle of notifyObservers(); iterating the live
        // list would throw ConcurrentModificationException here
        assertDoesNotThrow(() -> restaurant.markOrderPrepared(10));

        assertTrue(jane.isServed());
        assertEquals(1, john.getNotifications());
        assertEquals(1, mike.getNotifications());
        assertEquals(2, restaurant.getObserverCount());
    }
}
