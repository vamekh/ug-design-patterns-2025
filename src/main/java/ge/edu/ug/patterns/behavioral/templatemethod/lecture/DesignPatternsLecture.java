package ge.edu.ug.patterns.behavioral.templatemethod.lecture;

import java.util.Map;

public class DesignPatternsLecture extends Lecture {
    private int weekNumber;

    private static Map<Integer, String> topicsByWeek = Map.of(
        1, "Introduction to Design Patterns",
        2, "Creational Patterns",
        3, "Structural Patterns",
        4, "Behavioral Patterns",
        5, "Advanced Design Patterns"
    );

    public DesignPatternsLecture(int weekNumber) {
        super();
        this.weekNumber = weekNumber;
    }

    @Override
    protected void greetStudents() {
        System.out.println("Hello students! Welcome to the Design Patterns lecture for week " + weekNumber);
    }

    @Override
    protected void introduceTopic() {
        System.out.println("Introducing Design Patterns for Week " + weekNumber + ": " + topicsByWeek.getOrDefault(weekNumber, "Unknown Topic"));
    }

    @Override
    protected void explainTopic() {
        System.out.println("Explaining Design Patterns" + " for Week " + weekNumber + ": " + topicsByWeek.getOrDefault(weekNumber, "Unknown Topic"));
    }

    @Override
    protected void assignTheTask() {
        System.out.println("Assigning tasks related to Design Patterns" + " for Week " + weekNumber + ": " + topicsByWeek.getOrDefault(weekNumber, "Unknown Topic"));
    }

    @Override
    protected void summarizeTopic() {
        System.out.println("Summarizing Design Patterns" + " for Week " + weekNumber + ": " + topicsByWeek.getOrDefault(weekNumber, "Unknown Topic"));
    }
}
