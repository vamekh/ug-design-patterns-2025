package ge.edu.ug.patterns.creational.factorymethod.logistics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class LogisticsTest {
    // This code uses the Factory Method pattern:
    // 1. Transport is the Product, Truck and Ship are Concrete Products
    // 2. Logistics is the Creator: planDelivery() uses the factory method createTransport()
    // 3. RoadLogistics and SeaLogistics are Concrete Creators overriding only the factory method
    // 4. The client picks a Logistics once and never names a concrete Transport

    @Test
    public void testFactoryMethod() {
        Logistics logistics = new RoadLogistics();

        assertInstanceOf(Truck.class, logistics.createTransport());
        assertEquals("Delivering Books to Kutaisi by truck...", logistics.planDelivery("Kutaisi", "Books"));
    }

    @Test
    public void testSeaLogistics() {
        Logistics logistics = new SeaLogistics();

        assertInstanceOf(Ship.class, logistics.createTransport());
        assertEquals("Delivering Books to overseas by ship...", logistics.planDelivery("overseas", "Books"));
    }
}
