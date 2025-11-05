package ge.edu.ug.patterns.behavioral.chainofresponsibility.vacation;

public abstract class VacationChecker {
    VacationChecker next;

    public VacationChecker setNext(VacationChecker next) {
        this.next = next;
        return next;
    }

    protected abstract boolean handle(Vacation vacation);

    protected boolean handleNext(Vacation vacation) {
        if (next != null) return next.handle(vacation);
        else { System.out.println("\n✅ No more checks to perform ✅");return true;}
    }
}
