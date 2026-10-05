package ge.edu.ug.patterns.behavioral.observer.evaluationnotifier;

import java.util.ArrayList;
import java.util.List;

// Concrete Subject: notifies only the students whose topic matches the UG code
public class OnlineUG implements Observable {
    private final List<Observer> students = new ArrayList<>();

    @Override
    public void subscribe(Observer student) {
        students.add(student);
    }

    @Override
    public void unsubscribe(Observer student) {
        students.remove(student);
    }

    public void addEvaluation(Integer ugCode, Integer evaluation) {
        System.out.println("OnlineUG: " + ugCode + " received evaluation: " + evaluation);
        // equals, not ==: Integer objects above 127 are not cached
        students.stream()
                .filter(s -> ugCode.equals(s.getTopic()))
                .forEach(s -> s.notify(evaluation));
    }
}
