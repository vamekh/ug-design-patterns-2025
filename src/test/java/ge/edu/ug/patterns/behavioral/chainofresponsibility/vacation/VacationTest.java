package ge.edu.ug.patterns.behavioral.chainofresponsibility.vacation;

import org.junit.jupiter.api.Test;

import java.util.Date;

class VacationTest {
    @Test
    public void testVacation() {
        Vacation vacation = new Vacation("Mary", new Date(), 10);

        VacationChecker checker = new VacationLengthChecker();
        checker
                .setNext(new VacationRemainingDaysChecker())
                .setNext(new VacationRemainingDaysChecker());

        checker.handle(vacation);
    }

}
