package ge.edu.ug.patterns.behavioral.state.coffeemachine;

// Concrete State
public class MachineCleaningState implements CoffeeMachineState {
    private final CoffeeMachine machine;

    public MachineCleaningState(CoffeeMachine machine) {
        this.machine = machine;
    }

    String start() {
        machine.setCurrentState(this);
        machine.simulate("Cleaning");
        machine.resetCupCounter();
        machine.setCurrentState(new MachineIdleState(machine));
        return "Machine is clean.";
    }

    @Override
    public String makeCoffee() {
        return "Wait until cleaning is finished!";
    }

    @Override
    public String clean() {
        return "Wait until cleaning is finished! You're too tidy!";
    }

    @Override
    public String name() {
        return "CLEANING";
    }
}
