package ge.edu.ug.patterns.behavioral.state.coffeemachine;

// Context: delegates every action to the current state object.
public class CoffeeMachine {
    private int waterLevel;
    private int beansLevel;
    private final int cupsBeforeCleaning;
    private final ProcessSimulator simulator;
    private int cupsSinceCleaning = 0;
    private CoffeeMachineState currentState = new MachineIdleState(this);

    public CoffeeMachine() {
        this(100, 75, 3, step -> { });
    }

    public CoffeeMachine(int waterLevel, int beansLevel, int cupsBeforeCleaning, ProcessSimulator simulator) {
        this.waterLevel = waterLevel;
        this.beansLevel = beansLevel;
        this.cupsBeforeCleaning = cupsBeforeCleaning;
        this.simulator = simulator;
    }

    public String makeCoffee() {
        return currentState.makeCoffee();
    }

    public String clean() {
        return currentState.clean();
    }

    public String getStateName() {
        return currentState.name();
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public int getBeansLevel() {
        return beansLevel;
    }

    // --- used by the states ---

    void setCurrentState(CoffeeMachineState newState) {
        this.currentState = newState;
    }

    boolean hasResources() {
        return waterLevel >= 50 && beansLevel >= 15;
    }

    void useResources() {
        waterLevel -= 50;
        beansLevel -= 15;
        cupsSinceCleaning++;
    }

    boolean needsCleaning() {
        return cupsSinceCleaning >= cupsBeforeCleaning;
    }

    void resetCupCounter() {
        cupsSinceCleaning = 0;
    }

    void simulate(String step) {
        simulator.simulate(step);
    }
}
