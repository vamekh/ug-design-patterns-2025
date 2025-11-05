package ge.edu.ug.patterns.behavioral.observer.jobseeker;

public interface Observable {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers(JobPost jobPost);
}
