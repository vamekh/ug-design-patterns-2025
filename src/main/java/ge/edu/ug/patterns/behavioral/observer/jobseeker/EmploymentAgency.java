package ge.edu.ug.patterns.behavioral.observer.jobseeker;

import java.util.ArrayList;
import java.util.List;

public class EmploymentAgency implements Observable {
    List<Observer> observers = new ArrayList<>();

    public void postJob(JobPost jobPost) {
        System.out.printf("Job has been posted! %s\n", jobPost.title);
        notifyObservers(jobPost);
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(JobPost jobPost) {
        observers.forEach(observer -> observer.onJobPosted(jobPost));
    }
}
