package ge.edu.ug.patterns.behavioral.nullobject.logger;

public class ConsoleLogger implements Logger {
    @Override
    public void warn(String message) {
        System.out.println("WARNING: " + message);
    }

    @Override
    public void log(Exception e) {
        System.out.println("ERROR: " + e.getMessage());
    }
}
