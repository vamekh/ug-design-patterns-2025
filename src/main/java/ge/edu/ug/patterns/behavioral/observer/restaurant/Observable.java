package ge.edu.ug.patterns.behavioral.observer.restaurant;

// Subject
public interface Observable {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers(KitchenNotification notification);
}
