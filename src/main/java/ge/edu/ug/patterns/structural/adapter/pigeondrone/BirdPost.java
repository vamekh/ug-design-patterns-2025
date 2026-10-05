package ge.edu.ug.patterns.structural.adapter.pigeondrone;

// Legacy pigeon service with its own, incompatible interface
public interface BirdPost {
    void deliver(String address, String message);
}
