package ge.edu.ug.patterns.behavioral.chainofresponsibility.vacation;

// Handler: does its own check, then passes the request to the next one
public abstract class VacationChecker {
    private VacationChecker next;

    public VacationChecker setNext(VacationChecker next) {
        this.next = next;
        return next;
    }

    public abstract boolean handle(Vacation vacation);

    protected boolean handleNext(Vacation vacation) {
        if (next != null) {
            return next.handle(vacation);
        }
        System.out.println("✅ No more checks to perform ✅");
        return true;
    }
}
