package ge.edu.ug.patterns.behavioral.chainofresponsibility.studentexamwork;

public class WorkIsEmptyChecker extends StudentWorkChecker {
    @Override
    public boolean handle(StudentWork studentWork) {
        if(studentWork.theWork == null){
            System.out.println("❌ Student's work is empty");
            return false;
        }
        System.out.println("✅ Student's work is not empty");
        return handleNext(studentWork);
    }
}
