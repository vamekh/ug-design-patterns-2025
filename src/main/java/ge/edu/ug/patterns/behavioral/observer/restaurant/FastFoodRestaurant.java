package ge.edu.ug.patterns.behavioral.observer.restaurant;

import java.util.HashSet;
import java.util.Set;

// PROBLEM: the kitchen only records which orders are ready. Every HungryPerson has to
// keep looking at the screen (isReady) to find out, so someone must drive those checks
// in a loop, and most checks are wasted "not yet" answers.
public class FastFoodRestaurant {

    private final Set<Integer> preparedOrders = new HashSet<>();

    public void markOrderPrepared(int receiptNumber) {
        System.out.println("Kitchen: order " + receiptNumber + " is ready");
        preparedOrders.add(receiptNumber);
    }

    public boolean isReady(int receiptNumber) {
        return preparedOrders.contains(receiptNumber);
    }
}
