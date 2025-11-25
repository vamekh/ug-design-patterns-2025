package ge.edu.ug.patterns.behavioral.state.coffeemachine;

public class MachineMakingState implements CoffeeMachineState {
    CoffeeMachine machine;

    public MachineMakingState(CoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public void makeCoffee() {
        System.out.println("Don't you see the machine is busy?!");
    }

    @Override
    public void clean() {
        System.out.println("Don't you see the machine is busy?!");
    }
}
