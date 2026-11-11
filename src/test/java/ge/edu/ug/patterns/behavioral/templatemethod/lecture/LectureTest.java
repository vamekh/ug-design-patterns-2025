package ge.edu.ug.patterns.behavioral.templatemethod.lecture;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LectureTest {
    @Test
    public void testLecture() {
        Lecture mathLecture = new MathLecture();
        Lecture designPatternsLecture = new DesignPatternsLecture(1);

        mathLecture.readLecture();
        designPatternsLecture.readLecture();
    }

}
