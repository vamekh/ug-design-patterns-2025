package ge.edu.ug.patterns.behavioral.state.coffeemachine;

// Simulates a slow machine step (brewing, pouring, cleaning). Inject a no-op in tests.
public interface ProcessSimulator {
    void simulate(String step);
}
