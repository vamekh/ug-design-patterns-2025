package ge.edu.ug.patterns.behavioral.chainofresponsibility.vacation;

import java.util.Date;

public class Vacation {
    String employee;
    Date startDate;
    Date endDate;
    private int days;

    public Vacation(String employee, Date startDate, int days) {
        this.employee = employee;
        this.days = days;
        this.startDate = startDate;
        this.endDate = new Date(startDate.getTime() + (long) days * 1000 * 60 * 60 * 24);
    }

    public int getLengthInDays() {
        return days;
    }
}
