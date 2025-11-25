package ge.edu.ug.patterns.behavioral.state.coffeemachine;

public class MachineCleaningState implements CoffeeMachineState {
    CoffeeMachine machine;

    public MachineCleaningState(CoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public void makeCoffee() {
        System.out.println("Wait until cleaning is finished!");
    }

    @Override
    public void clean() {
        System.out.println("Wait until cleaning is finished! You're too tidy!");
    }
}
