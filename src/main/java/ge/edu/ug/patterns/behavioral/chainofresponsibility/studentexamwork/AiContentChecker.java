package ge.edu.ug.patterns.behavioral.chainofresponsibility.studentexamwork;

public class AiContentChecker extends StudentWorkChecker {
    @Override
    public boolean handle(StudentWork studentWork) {
        if(studentWork.theWork == null || studentWork.theWork.contains("-")){
            System.out.println("❌ Student's work contains AI content");
            return false;
        }
        System.out.println("✅ Student's work does not contain AI content");
        return handleNext(studentWork);
    }
}
