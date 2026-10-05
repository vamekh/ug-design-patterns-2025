package ge.edu.ug.patterns.behavioral.observer.restaurant;

import java.util.ArrayList;
import java.util.List;

// Concrete Subject: the kitchen announces every prepared order
public class FastFoodRestaurant implements Observable {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(KitchenNotification notification) {
        // Iterate over a copy: an observer may unsubscribe while being notified
        for (Observer observer : List.copyOf(observers)) {
            observer.notify(notification);
        }
    }

    public void markOrderPrepared(int receiptNumber) {
        System.out.println("Kitchen: order " + receiptNumber + " is ready");
        notifyObservers(new KitchenNotification(receiptNumber));
    }

    public int getObserverCount() {
        return observers.size();
    }
}
