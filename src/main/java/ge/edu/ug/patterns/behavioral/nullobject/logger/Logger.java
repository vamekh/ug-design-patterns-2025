package ge.edu.ug.patterns.behavioral.nullobject.logger;

public interface Logger {
    void warn(String message);

    void log(Exception e);
}
