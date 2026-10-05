package ge.edu.ug.patterns.behavioral.state.coffeemachine;

// Concrete State
public class MachineMakingState implements CoffeeMachineState {
    private final CoffeeMachine machine;

    public MachineMakingState(CoffeeMachine machine) {
        this.machine = machine;
    }

    String start() {
        machine.setCurrentState(this);
        machine.useResources();
        machine.simulate("Brewing");
        machine.simulate("Pouring");
        machine.setCurrentState(machine.needsCleaning()
                ? new MachineToBeCleanedState(machine)
                : new MachineIdleState(machine));
        return "Coffee is ready.";
    }

    @Override
    public String makeCoffee() {
        return "Don't you see the machine is busy?!";
    }

    @Override
    public String clean() {
        return "Don't you see the machine is busy?!";
    }

    @Override
    public String name() {
        return "MAKING";
    }
}
