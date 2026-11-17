package ge.edu.ug.patterns.behavioral.strategy.lecture;

public class SpeakOutStrategy implements LectureStrategy {
    @Override
    public void readLecture(String topic) {
        System.out.println("Speaking out about " + topic + ".");
    }
}
