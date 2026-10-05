package ge.edu.ug.patterns.behavioral.state.coffeemachine;

// PROBLEM: every action is a switch over the State enum. Behaviour for one state is spread
// across all methods, and adding a state (e.g. DESCALING) or an action (e.g. refill)
// means editing every switch in this class.
public class CoffeeMachine {
    private int waterLevel;
    private int beansLevel;
    private final int cupsBeforeCleaning;
    private final ProcessSimulator simulator;
    private int cupsSinceCleaning = 0;
    private State state = State.IDLE;

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
        switch (state) {
            case IDLE:
                if (waterLevel < 50 || beansLevel < 15) {
                    return "Not enough resources to make coffee.";
                }
                state = State.MAKING;
                waterLevel -= 50;
                beansLevel -= 15;
                simulator.simulate("Brewing");
                simulator.simulate("Pouring");
                cupsSinceCleaning++;
                state = cupsSinceCleaning >= cupsBeforeCleaning ? State.TO_BE_CLEANED : State.IDLE;
                return "Coffee is ready.";
            case MAKING:
                return "Don't you see the machine is busy?!";
            case CLEANING:
                return "Wait until cleaning is finished!";
            case TO_BE_CLEANED:
                return "Clean machine first!";
            default:
                throw new IllegalStateException("Unknown state " + state);
        }
    }

    public String clean() {
        switch (state) {
            case IDLE:
            case TO_BE_CLEANED:
                state = State.CLEANING;
                simulator.simulate("Cleaning");
                cupsSinceCleaning = 0;
                state = State.IDLE;
                return "Machine is clean.";
            case MAKING:
                return "Don't you see the machine is busy?!";
            case CLEANING:
                return "Wait until cleaning is finished! You're too tidy!";
            default:
                throw new IllegalStateException("Unknown state " + state);
        }
    }

    public String getStateName() {
        return state.name();
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public int getBeansLevel() {
        return beansLevel;
    }
}
