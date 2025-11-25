package ge.edu.ug.patterns.behavioral.state.coffeemachine;

public class CoffeeMachine implements CoffeeMachineState {

    private int waterLevel = 100;
    private int beansLevel = 75;

    private CoffeeMachineState currentState = new MachineIdleState(this);

    protected void setCurrentState(CoffeeMachineState newState) {
        this.currentState = newState;
    }

    @Override
    public void makeCoffee() {
       this.currentState.makeCoffee();
    }

    @Override
    public void clean() {
        this.currentState.clean();
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public int getBeansLevel() {
        return beansLevel;
    }

    public void setBeansLevel(int beansLevel) {
        this.beansLevel = beansLevel;
    }

    protected void simulateProcess() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                System.out.printf("\r.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
