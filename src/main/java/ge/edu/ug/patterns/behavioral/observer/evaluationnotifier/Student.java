package ge.edu.ug.patterns.behavioral.observer.evaluationnotifier;

import java.util.ArrayList;
import java.util.List;

// Concrete Observer
public class Student implements Observer {
    Integer ugCode;
    private final List<Integer> receivedEvaluations = new ArrayList<>();

    public Student(Integer ugCode) {
        this.ugCode = ugCode;
    }

    @Override
    public Integer getTopic() {
        return ugCode;
    }

    @Override
    public void notify(Integer evaluation) {
        System.out.println("Student " + ugCode + " received evaluation: " + evaluation);
        receivedEvaluations.add(evaluation);
    }

    public List<Integer> getReceivedEvaluations() {
        return receivedEvaluations;
    }
}
