package ge.edu.ug.patterns.behavioral.state.coffeemachine;

// State
public interface CoffeeMachineState {
    String makeCoffee();

    String clean();

    String name();
}
