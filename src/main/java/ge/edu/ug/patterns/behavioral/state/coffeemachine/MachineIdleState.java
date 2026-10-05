package ge.edu.ug.patterns.behavioral.state.coffeemachine;

// Concrete State
public class MachineIdleState implements CoffeeMachineState {
    private final CoffeeMachine machine;

    public MachineIdleState(CoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public String makeCoffee() {
        if (!machine.hasResources()) {
            return "Not enough resources to make coffee.";
        }
        return new MachineMakingState(machine).start();
    }

    @Override
    public String clean() {
        return new MachineCleaningState(machine).start();
    }

    @Override
    public String name() {
        return "IDLE";
    }
}
