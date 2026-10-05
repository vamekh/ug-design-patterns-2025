package ge.edu.ug.patterns.behavioral.nullobject.logger;

// Null Object: a Logger that silently does nothing, shared as a single instance
public class LoggerNullObject implements Logger {

    private static final LoggerNullObject INSTANCE = new LoggerNullObject();

    private LoggerNullObject() {
    }

    public static LoggerNullObject getInstance() {
        return INSTANCE;
    }

    @Override
    public void warn(String message) {
        // Do nothing
    }

    @Override
    public void log(Exception e) {
        // Do nothing
    }
}
