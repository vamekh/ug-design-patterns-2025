package ge.edu.ug.patterns.behavioral.state.coffeemachine;

// Concrete State
public class MachineToBeCleanedState implements CoffeeMachineState {
    private final CoffeeMachine machine;

    public MachineToBeCleanedState(CoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public String makeCoffee() {
        return "Clean machine first!";
    }

    @Override
    public String clean() {
        return new MachineCleaningState(machine).start();
    }

    @Override
    public String name() {
        return "TO_BE_CLEANED";
    }
}
