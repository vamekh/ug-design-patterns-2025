package ge.edu.ug.patterns.behavioral.observer.jobseeker;

// Subject
public interface Observable {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers(JobPost jobPost);
}
