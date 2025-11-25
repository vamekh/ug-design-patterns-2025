package ge.edu.ug.patterns.behavioral.state.coffeemachine;

public interface CoffeeMachineState {
    abstract void makeCoffee();
    abstract void clean();
}
