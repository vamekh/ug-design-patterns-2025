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
        List<Vehicle> duplicates = vehicles.stream().map(Vehicle::copy).toList();
        duplicates.forEach(System.out::println);

        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle original = vehicles.get(i);
            Vehicle copy = duplicates.get(i);
            Assertions.assertNotSame(original, copy);                       // a new object...
            Assertions.assertSame(original.getClass(), copy.getClass());    // ...of the same concrete type...
            Assertions.assertEquals(original.toString(), copy.toString());  // ...with the same content
        }
    }

    @Test
    public void testRegistry() {
        Vehicle car1 = this.cache.getVehicle("family-car");
        car1.setColor("SkyBlue");
        System.out.println("Typical family car with modified color " + car1);
        Vehicle car2 = this.cache.getVehicle("family-car");
        System.out.println("Typical family car with default color  " + car2);

        Assertions.assertNotSame(car1, car2);          // the registry hands out a fresh copy each time
        Assertions.assertNotEquals(car1.getColor(), car2.getColor()); // changing a copy leaves the prototype untouched
    }

    @Test
    public void testUnknownRegistryKey() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.cache.getVehicle("space-car"));
    }

}
