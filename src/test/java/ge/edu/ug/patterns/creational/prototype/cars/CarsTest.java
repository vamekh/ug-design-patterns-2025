package ge.edu.ug.patterns.creational.prototype.cars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarsTest {
    private VehicleCache cache = new VehicleCache();

    @Test
    public void testCars() {
        List<Vehicle> vehicles = List.of(
                new Car("BMW", "M3", "Red", "Electric", 300),
                new Bus("Ikarus", "Dragon", "Red", "Diesel", 50),
                new Car("Tesla", "Model S", "Red", "V8", 250)
        );
        List<Vehicle> duplicates = vehicles.stream().map(Vehicle::clone).toList();
        duplicates.forEach(System.out::println);
    }

    @Test
    public void testRegistry() {
        Vehicle car1 = this.cache.getVehicle("family-car");
        car1.color = "SkyBlue";
        System.out.println("Typical family car with modified color " + car1);
        Vehicle car2 = this.cache.getVehicle("family-car");
        System.out.println("Typical family car with default color  " + car2);

        Assertions.assertNotEquals(car1, car2);
    }

}
