package ge.edu.ug.patterns.behavioral.strategy.lecture;

public class Lecturer {
    private final String firstName;
    private final String lastName;

    public Lecturer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void readLecture(LectureStrategy lectureStrategy, String topic) {
        System.out.println("Lecturer " + firstName + " " + lastName + " is reading lecture on " + topic + ".");
        lectureStrategy.readLecture(topic);
    }
}
