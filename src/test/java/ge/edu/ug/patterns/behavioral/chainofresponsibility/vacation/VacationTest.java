package ge.edu.ug.patterns.behavioral.chainofresponsibility.vacation;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// PROBLEM: the behaviour is correct, but every rule is tangled inside
// VacationService.approve(); there is no way to test or reuse one check on its own.
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
}
