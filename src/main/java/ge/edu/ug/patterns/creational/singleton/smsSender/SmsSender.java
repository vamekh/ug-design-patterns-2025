package ge.edu.ug.patterns.creational.singleton.smsSender;

public class SmsSender {
    public static volatile SmsSender instance;

private SmsSender(){}

        public static SmsSender getInstance() {
        if(instance == null) {
            synchronized (SmsSender.class) {
                instance = new SmsSender();
            }
        }
        return instance;
    };
}
