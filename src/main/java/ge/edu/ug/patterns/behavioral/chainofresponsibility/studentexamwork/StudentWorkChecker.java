package ge.edu.ug.patterns.behavioral.chainofresponsibility.studentexamwork;

public abstract class StudentWorkChecker {
    protected StudentWorkChecker next;

    public abstract boolean handle(StudentWork studentWork);

    public boolean handleNext(StudentWork studentWork) {
        if(next == null) {
            System.out.println("✅ No more checks to perform ✅");
            return true;
        }
        return next.handle(studentWork);
    }

    public StudentWorkChecker setNext(StudentWorkChecker next) {
        this.next = next;
        return next;
    }
}
