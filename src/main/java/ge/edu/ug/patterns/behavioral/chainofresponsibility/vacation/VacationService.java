package ge.edu.ug.patterns.behavioral.chainofresponsibility.vacation;

import java.util.Map;

import static ge.edu.ug.patterns.behavioral.chainofresponsibility.vacation.VacationConfigs.MAX_DAYS;
import static ge.edu.ug.patterns.behavioral.chainofresponsibility.vacation.VacationConfigs.MIN_DAYS;

// PROBLEM: approve() does every check itself in one nested if/else.
// Each new rule (e.g. "manager must agree") makes the nesting deeper and means
// editing this method again; checks cannot be reordered, reused or tested alone.
public class VacationService {
    private final Map<String, Integer> remainingDays;

    public VacationService(Map<String, Integer> remainingDays) {
        this.remainingDays = remainingDays;
    }

    public boolean approve(Vacation vacation) {
        int days = vacation.getLengthInDays();
        if (days >= MIN_DAYS) {
            if (days <= MAX_DAYS) {
                System.out.println("✅ Vacation's requested length is valid.");
                int daysRemaining = remainingDays.getOrDefault(vacation.employee, MAX_DAYS);
                if (days <= daysRemaining) {
                    System.out.println("✅ Employee has enough days remaining for vacation.");
                    System.out.println("✅ No more checks to perform ✅");
                    return true;
                } else {
                    System.out.println("❌ Employee doesn't have enough days remaining for vacation.");
                    return false;
                }
            } else {
                System.out.println("❌ Vacation cannot exceed " + MAX_DAYS + " days");
                return false;
            }
        } else {
            System.out.println("❌ Vacation must be at least " + MIN_DAYS + " days");
            return false;
        }
    }
}
