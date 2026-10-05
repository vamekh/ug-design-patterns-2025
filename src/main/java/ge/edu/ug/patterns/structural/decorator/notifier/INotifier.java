package ge.edu.ug.patterns.structural.decorator.notifier;

// Component
public interface INotifier {
    void send(String message);

    String getUsername();
}
