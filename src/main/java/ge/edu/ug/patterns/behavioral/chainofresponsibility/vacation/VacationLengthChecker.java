package ge.edu.ug.patterns.behavioral.chainofresponsibility.vacation;

import static ge.edu.ug.patterns.behavioral.chainofresponsibility.vacation.VacationConfigs.MAX_DAYS;
import static ge.edu.ug.patterns.behavioral.chainofresponsibility.vacation.VacationConfigs.MIN_DAYS;

public class VacationLengthChecker extends VacationChecker {

    @Override
    protected boolean handle(Vacation vacation) {
        int days = vacation.getLengthInDays();
        if (days < MIN_DAYS) {
            System.out.println("❌ Vacation must be at least " + MIN_DAYS + " days");
            System.out.println("❌ Vacation must be at least " + MIN_DAYS + " days");
            return false;
        }
        if (days > MAX_DAYS) {
            System.out.println("❌ Vacation cannot exceed " + MAX_DAYS + " days");
            return false;
        }

        System.out.println("✅ Vacation's requested length is valid.");
        return handleNext(vacation);
    }
}
