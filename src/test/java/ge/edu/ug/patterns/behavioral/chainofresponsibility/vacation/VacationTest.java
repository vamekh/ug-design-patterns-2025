package ge.edu.ug.patterns.behavioral.chainofresponsibility.vacation;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VacationTest {

    private final VacationService service = new VacationService(Map.of(
            "John", 5,
            "Nick", 10,
            "Mary", 5
    ));

    @Test
    void approvesVacationWithinLimits() {
        assertTrue(service.approve(new Vacation("Nick", LocalDate.of(2026, 7, 1), 10)));
    }

    @Test
    void rejectsVacationLongerThanRemainingDays() {
        assertFalse(service.approve(new Vacation("Mary", LocalDate.of(2026, 7, 1), 10)));
    }

    @Test
    void rejectsTooShortVacation() {
        assertFalse(service.approve(new Vacation("John", LocalDate.of(2026, 7, 1), 0)));
    }

    @Test
    void rejectsTooLongVacation() {
        assertFalse(service.approve(new Vacation("John", LocalDate.of(2026, 7, 1), 20)));
    }

    @Test
    void unknownEmployeeGetsTheDefaultAllowance() {
        assertTrue(service.approve(new Vacation("Anna", LocalDate.of(2026, 7, 1), 14)));
    }

    @Test
    void eachCheckerWorksOnItsOwn() {
        VacationChecker checker = new VacationRemainingDaysChecker(Map.of("Mary", 5));

        assertTrue(checker.handle(new Vacation("Mary", LocalDate.of(2026, 7, 1), 5)));
        assertFalse(checker.handle(new Vacation("Mary", LocalDate.of(2026, 7, 1), 6)));
    }

    @Test
    void newRuleIsAddedWithoutEditingExistingCheckers() {
        VacationChecker noSummerVacations = new VacationChecker() {
            @Override
            public boolean handle(Vacation vacation) {
                if (vacation.startDate.getMonthValue() == 8) {
                    return false;
                }
                return handleNext(vacation);
            }
        };
        VacationChecker chain = new VacationLengthChecker();
        chain.setNext(noSummerVacations)
                .setNext(new VacationRemainingDaysChecker(Map.of()));

        assertTrue(chain.handle(new Vacation("Nick", LocalDate.of(2026, 7, 1), 5)));
        assertFalse(chain.handle(new Vacation("Nick", LocalDate.of(2026, 8, 1), 5)));
    }
}
