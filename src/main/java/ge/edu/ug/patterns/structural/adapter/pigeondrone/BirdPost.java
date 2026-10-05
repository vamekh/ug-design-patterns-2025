package ge.edu.ug.patterns.structural.adapter.pigeondrone;

// Adaptee: legacy pigeon service with its own, incompatible interface
public interface BirdPost {
    void deliver(String address, String message);
}
