package ge.edu.ug.patterns.behavioral.strategy.lecture;

public class FilmStrategy implements LectureStrategy {
    @Override
    public void readLecture(String topic) {
        System.out.println("Watching film about " + topic + " together with students. ");
    }
}
