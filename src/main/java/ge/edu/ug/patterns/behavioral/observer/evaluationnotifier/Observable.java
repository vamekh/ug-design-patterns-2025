package ge.edu.ug.patterns.behavioral.observer.evaluationnotifier;

// Subject
public interface Observable {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
}
