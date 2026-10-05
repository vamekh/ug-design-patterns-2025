package ge.edu.ug.patterns.behavioral.chainofresponsibility.vacation;

import java.util.Map;

import static ge.edu.ug.patterns.behavioral.chainofresponsibility.vacation.VacationConfigs.MAX_DAYS;

// Concrete Handler
public class VacationRemainingDaysChecker extends VacationChecker {
    private final Map<String, Integer> remainingDays;

    public VacationRemainingDaysChecker(Map<String, Integer> remainingDays) {
        this.remainingDays = remainingDays;
    }

    @Override
    public boolean handle(Vacation vacation) {
        int daysRemaining = remainingDays.getOrDefault(vacation.employee, MAX_DAYS);
        if (vacation.getLengthInDays() > daysRemaining) {
            System.out.println("❌ Employee doesn't have enough days remaining for vacation.");
            return false;
        }
        System.out.println("✅ Employee has enough days remaining for vacation.");
        return handleNext(vacation);
    }
}
