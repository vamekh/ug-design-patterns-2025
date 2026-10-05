package ge.edu.ug.patterns.behavioral.observer.evaluationnotifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// PROBLEM: Online UG only stores evaluations. A Student learns about a new grade
// only if they log in and ask getEvaluations() - and must remember how many grades
// they have already seen. Until they check, a posted grade goes unnoticed.
public class OnlineUG {
    private final Map<Integer, List<Integer>> evaluations = new HashMap<>();

    public void addEvaluation(Integer ugCode, Integer evaluation) {
        System.out.println("OnlineUG: " + ugCode + " received evaluation: " + evaluation);
        evaluations.computeIfAbsent(ugCode, k -> new ArrayList<>()).add(evaluation);
    }

    public List<Integer> getEvaluations(Integer ugCode) {
        return List.copyOf(evaluations.getOrDefault(ugCode, List.of()));
    }
}
