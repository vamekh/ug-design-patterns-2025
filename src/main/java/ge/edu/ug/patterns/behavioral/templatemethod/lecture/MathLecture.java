package ge.edu.ug.patterns.behavioral.templatemethod.lecture;

public class MathLecture extends Lecture{

    @Override
    protected void introduceTopic() {
        System.out.println("Today we will learn about the Pythagorean theorem.");
    }

    @Override
    protected void explainTopic() {
        System.out.println("The Pythagorean theorem states that in a right triangle, the square of the hypotenuse is equal to the sum of the squares of the other two sides.");
    }

    @Override
    protected void assignTheTask() {
        System.out.println("Assigning homework on the Pythagorean theorem.");
    }

    @Override
    protected void summarizeTopic() {
        System.out.println("In summary, the Pythagorean theorem is a fundamental principle in geometry that relates the lengths of the sides of a right triangle.");
    }
}
