package ge.edu.ug.patterns.creational.prototype.cars;

import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    public void testCars() {
        Car tesla = new Car("Tesla", "Model S", "Red", "V8", 250);
        Car clone = (Car) tesla.clone();
        System.out.println(clone);


    }

}
