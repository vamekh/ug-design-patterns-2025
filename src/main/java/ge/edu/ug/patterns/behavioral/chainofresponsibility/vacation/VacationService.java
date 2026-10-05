package ge.edu.ug.patterns.behavioral.chainofresponsibility.vacation;

import java.util.Map;

// Client: builds the chain once and sends each request to its first handler
public class VacationService {
    private final VacationChecker chain;

    public VacationService(Map<String, Integer> remainingDays) {
        chain = new VacationLengthChecker();
        chain.setNext(new VacationRemainingDaysChecker(remainingDays));
    }

    public boolean approve(Vacation vacation) {
        return chain.handle(vacation);
    }
}
