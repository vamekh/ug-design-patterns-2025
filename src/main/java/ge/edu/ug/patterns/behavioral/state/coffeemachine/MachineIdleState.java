package ge.edu.ug.patterns.behavioral.state.coffeemachine;

public class MachineIdleState implements CoffeeMachineState {
    CoffeeMachine machine;

    public MachineIdleState(CoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public void makeCoffee() {
        System.out.println("Curr state idle. makeCoffee()");
        machine.setCurrentState(new MachineMakingState(this.machine));
        if (machine.getWaterLevel() >= 50 && machine.getBeansLevel() >= 15) {
            machine.setWaterLevel(machine.getWaterLevel() - 50);
            machine.setBeansLevel((machine.getBeansLevel() - 15));
            System.out.println("Brewing started.");
            machine.simulateProcess();
            System.out.println("\rPouring started.");
            machine.simulateProcess();
            if ((Math.random() * 4) % 4 == 0) {
                machine.setCurrentState(new MachineToBeCleanedState(this.machine));
            } else {
                machine.setCurrentState(new MachineIdleState(this.machine));
            }
        } else {
            System.out.println("Not enough resources to make coffee.");
            machine.setCurrentState(new MachineIdleState(this.machine));
        }
    }

    @Override
    public void clean() {
        new Thread(() -> {
            machine.setCurrentState(new MachineCleaningState(this.machine));
            System.out.println("Cleaning started..");
            machine.simulateProcess();
            machine.setCurrentState(new MachineIdleState(this.machine));

        }).start();
    }
}
