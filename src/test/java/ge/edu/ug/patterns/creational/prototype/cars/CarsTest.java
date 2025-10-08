package ge.edu.ug.patterns.creational.prototype.cars;

import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    public void testCars() {
        Car tesla = new Car("Tesla", "Model S", "Red", "V8", 250);
        System.out.println(tesla);
        Car clone = new Car(
                tesla.brand,
                tesla.model,
                tesla.color,
                tesla.engineType,
                tesla.topSpeed
        );
        System.out.println(clone);
    }

}
