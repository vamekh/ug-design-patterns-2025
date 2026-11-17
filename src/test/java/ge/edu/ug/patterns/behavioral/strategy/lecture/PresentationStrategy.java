package ge.edu.ug.patterns.behavioral.strategy.lecture;

public class PresentationStrategy implements LectureStrategy {
    @Override
    public void readLecture(String topic) {
        System.out.println("Reading presentation lecture on " + topic + ".");
    }
}
