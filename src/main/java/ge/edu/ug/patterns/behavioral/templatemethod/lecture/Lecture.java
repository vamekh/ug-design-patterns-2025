package ge.edu.ug.patterns.behavioral.templatemethod.lecture;

public abstract class Lecture {

    public  final  void readLecture() {
        greetStudents();
        introduceTopic();
        explainTopic();
        summarizeTopic();
        assignTheTask();
        sayGoodbye();
    }

    protected void greetStudents(){
        System.out.println("Hello students!");
    }

    protected abstract void introduceTopic();
    protected abstract void explainTopic();
    protected abstract void summarizeTopic();
    protected abstract void assignTheTask();
    protected void sayGoodbye(){
        System.out.println("Goodbye students!");
    }
}
