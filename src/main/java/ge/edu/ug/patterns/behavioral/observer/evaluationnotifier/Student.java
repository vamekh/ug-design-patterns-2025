package ge.edu.ug.patterns.behavioral.observer.evaluationnotifier;

import java.util.ArrayList;
import java.util.List;

public class Student {
    Integer ugCode;
    OnlineUG onlineUG;
    private final List<Integer> receivedEvaluations = new ArrayList<>();

    public Student(Integer ugCode, OnlineUG onlineUG) {
        this.ugCode = ugCode;
        this.onlineUG = onlineUG;
    }

    // Polling: the student has to log in again and again
    public void checkForNewEvaluations() {
        List<Integer> all = onlineUG.getEvaluations(ugCode);
        for (int i = receivedEvaluations.size(); i < all.size(); i++) {
            notify(all.get(i));
        }
    }

    private void notify(Integer evaluation) {
        System.out.println("Student " + ugCode + " received evaluation: " + evaluation);
        receivedEvaluations.add(evaluation);
    }

    public List<Integer> getReceivedEvaluations() {
        return receivedEvaluations;
    }
}
