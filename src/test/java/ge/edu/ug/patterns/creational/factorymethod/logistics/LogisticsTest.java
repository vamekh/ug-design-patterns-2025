package ge.edu.ug.patterns.creational.factorymethod.logistics;

import org.junit.jupiter.api.Test;

public class LogisticsTest {
    // This code uses the Factory Method pattern:
    // 1. Transport interface acts as the Product
    // 2. Logistics class is the Creator with factory method createTransport()
    // 3. RoadLogistics is a Concrete Creator implementing the factory method
    // 4. Pattern allows creating transport objects without specifying exact class

    @Test
    public void testFactoryMethod() {
        Logistics logistics = new RoadLogistics();
        Transport transport = logistics.createTransport();
        transport.deliver("Mestia", "Furniture");
    }
}
