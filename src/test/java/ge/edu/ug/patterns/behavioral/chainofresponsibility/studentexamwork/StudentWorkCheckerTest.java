package ge.edu.ug.patterns.behavioral.chainofresponsibility.studentexamwork;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentWorkCheckerTest {
    @Test
    public void testStudentWorkCheckerChain() {
        StudentWork studentWork = new StudentWork();
        studentWork.ugCode = "UG12345";
        studentWork.theWork = "This is the student's work. - I swear it is not AI generated";

        StudentWorkChecker ugCodeChecker = new UgCodePresentedChecker();
        StudentWorkChecker workIsEmptyChecker = new WorkIsEmptyChecker();
        StudentWorkChecker aiContentChecker = new AiContentChecker();

        ugCodeChecker
                .setNext(workIsEmptyChecker)
                .setNext(aiContentChecker);

        ugCodeChecker.handle(studentWork);
    }
}
