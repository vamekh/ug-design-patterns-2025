package ge.edu.ug.patterns.creational.factorymethod.logistics;

import org.junit.jupiter.api.Test;

public class LogisticsTest {
    // The Factory Method pattern is needed here because:
    // 1. The LogisticsCompany creates different types of Transport objects (Ship, Truck)
    // 2. Object creation logic is hardcoded in the client class, making it difficult to extend
    // 3. The pattern would help delegate object creation to subclasses, making the system more flexible
    // 4. New transport types could be added without modifying existing client code

    @Test
    public void testFactoryMethod() {
        LogisticsCompany company = new LogisticsCompany();
        company.deliver("Kutaisi", "Books");
    }
}
