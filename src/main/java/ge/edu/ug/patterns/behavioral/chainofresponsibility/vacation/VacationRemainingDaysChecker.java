package ge.edu.ug.patterns.behavioral.chainofresponsibility.vacation;

import java.util.HashMap;
import java.util.Map;

import static ge.edu.ug.patterns.behavioral.chainofresponsibility.vacation.VacationConfigs.MAX_DAYS;

public class VacationRemainingDaysChecker extends VacationChecker {
    private static Map<String, Integer> daysMap = new HashMap<>();
    static {
        daysMap.put("John", 5);
        daysMap.put("Nick", 10);
        daysMap.put("Mary", 5);
    }

    @Override
    protected boolean handle(Vacation vacation) {
        int daysRemaining = daysMap.computeIfAbsent(vacation.employee, k -> MAX_DAYS);
        if(vacation.getLengthInDays() > daysRemaining){
            System.out.println("❌ Employee doesn't have enough days remaining for vacation.");
            return false;
        }
        System.out.println("✅ Employee has enough days remaining for vacation.");
        return handleNext(vacation);
    }
}
