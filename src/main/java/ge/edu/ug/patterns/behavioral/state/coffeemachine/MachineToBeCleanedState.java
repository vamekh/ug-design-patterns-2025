package ge.edu.ug.patterns.behavioral.state.coffeemachine;

public class MachineToBeCleanedState implements CoffeeMachineState {
    CoffeeMachine machine;

    public MachineToBeCleanedState(CoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public void makeCoffee() {
        System.out.println("Clean machine first!");
    }

    @Override
    public void clean() {
        System.out.println("Cleaning machine.");
        machine.simulateProcess();
        machine.setCurrentState(new MachineIdleState(this.machine));
    }
}
