package ge.edu.ug.patterns.behavioral.chainofresponsibility.vacation;

import java.time.LocalDate;

public class Vacation {
    String employee;
    LocalDate startDate;
    LocalDate endDate;
    private int days;

    public Vacation(String employee, LocalDate startDate, int days) {
        this.employee = employee;
        this.days = days;
        this.startDate = startDate;
        this.endDate = startDate.plusDays(days);
    }

    public int getLengthInDays() {
        return days;
    }
}
