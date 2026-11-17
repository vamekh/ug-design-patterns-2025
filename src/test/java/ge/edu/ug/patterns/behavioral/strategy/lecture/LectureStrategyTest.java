package ge.edu.ug.patterns.behavioral.strategy.lecture;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LectureStrategyTest {

    @Test
    public void testLectureStrategies() {
        Lecturer lecturer = new Lecturer("Albert", "Einstein");

        LectureStrategy presentationStrategy = new PresentationStrategy();
        LectureStrategy filmStrategy = new FilmStrategy();
        LectureStrategy speakOutStrategy = new SpeakOutStrategy();

        System.out.println("Using Presentation Strategy:");
        lecturer.readLecture(speakOutStrategy, "Theory of Relativity");

//        System.out.println("\nUsing Film Strategy:");
//        lecturer.readLecture(filmStrategy);
    }

}
