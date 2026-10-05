package ge.edu.ug.patterns.behavioral.observer.evaluationnotifier;

// Observer: subscribes to one topic (a UG code)
public interface Observer {
    Integer getTopic();
    void notify(Integer evaluation);
}
