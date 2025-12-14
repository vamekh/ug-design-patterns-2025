package ge.edu.ug.patterns.behavioral.state.coffeemachine;

import org.junit.jupiter.api.Test;

class CoffeeMachineTest {
    @Test
    public void testCoffeeMachine() throws InterruptedException {
        CoffeeMachine machine = new CoffeeMachine();
        machine.clean();
        Thread.sleep(6000);
        machine.makeCoffee();

    }

}
