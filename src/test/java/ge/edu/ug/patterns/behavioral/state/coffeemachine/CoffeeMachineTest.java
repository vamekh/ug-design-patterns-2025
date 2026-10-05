package ge.edu.ug.patterns.behavioral.state.coffeemachine;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// PROBLEM: the behaviour is correct, but every row of this state table lives inside a switch
// in CoffeeMachine. A new state would mean revisiting every method and every case.
class CoffeeMachineTest {

    @Test
    void makesCoffeeAndReturnsToIdle() {
        CoffeeMachine machine = new CoffeeMachine();
        assertEquals("Coffee is ready.", machine.makeCoffee());
        assertEquals("IDLE", machine.getStateName());
        assertEquals(50, machine.getWaterLevel());
        assertEquals(60, machine.getBeansLevel());
    }

    @Test
    void needsCleaningAfterConfiguredNumberOfCups() {
        CoffeeMachine machine = new CoffeeMachine(500, 500, 2, step -> { });
        machine.makeCoffee();
        assertEquals("IDLE", machine.getStateName());
        machine.makeCoffee();
        assertEquals("TO_BE_CLEANED", machine.getStateName());

        assertEquals("Clean machine first!", machine.makeCoffee());
        assertEquals("Machine is clean.", machine.clean());
        assertEquals("IDLE", machine.getStateName());
        assertEquals("Coffee is ready.", machine.makeCoffee());
    }

    @Test
    void refusesWithoutResources() {
        CoffeeMachine machine = new CoffeeMachine(40, 75, 3, step -> { });
        assertEquals("Not enough resources to make coffee.", machine.makeCoffee());
        assertEquals("IDLE", machine.getStateName());
    }

    @Test
    void isBusyWhileMakingOrCleaning() {
        List<String> seen = new ArrayList<>();
        CoffeeMachine[] holder = new CoffeeMachine[1];
        // The simulator pokes the machine in the middle of a step, like an impatient user.
        holder[0] = new CoffeeMachine(500, 500, 5, step -> {
            seen.add(step + ":" + holder[0].getStateName() + ":" + holder[0].makeCoffee() + "|" + holder[0].clean());
        });

        holder[0].makeCoffee();
        holder[0].clean();

        assertEquals(List.of(
                "Brewing:MAKING:Don't you see the machine is busy?!|Don't you see the machine is busy?!",
                "Pouring:MAKING:Don't you see the machine is busy?!|Don't you see the machine is busy?!",
                "Cleaning:CLEANING:Wait until cleaning is finished!|Wait until cleaning is finished! You're too tidy!"),
                seen);
    }
}
