package ge.edu.ug.patterns.behavioral.chainofresponsibility.studentexamwork;

public class UgCodePresentedChecker extends StudentWorkChecker {
    @Override
    public boolean handle(StudentWork studentWork) {
        if(studentWork.ugCode == null){
            System.out.println("❌ Student's UG code is not presented");
            return false;
        }
        System.out.println("✅ Student's UG code is presented");
        return handleNext(studentWork);
    }
}
