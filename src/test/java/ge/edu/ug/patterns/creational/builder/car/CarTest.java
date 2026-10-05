package ge.edu.ug.patterns.creational.builder.car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

// PROBLEM: every car is a row of positional arguments full of nulls.
// The "popular model" presets (Subaru Forester, Honda Fit) are copy-pasted for CarDto AND CarEntity,
// so changing a preset means finding every copy.
class CarTest {

    @Test
    public void testCustomCar() {
        // which null is price and which is mileage?
        CarDto car = new CarDto("Honda", "Fit", null, 2014, null, null, null);

        assertEquals(2014, car.getYear());
        assertNull(car.getPrice());
    }

    @Test
    public void testSubaruForesterDto() {
        // preset copy #1
        CarDto car = new CarDto("Subaru", "Forester", "Red", null, null, null, 5);

        assertEquals("Forester", car.getModel());
        assertEquals(5, car.getSeats());
        assertEquals("Red", car.getColor());
    }

    @Test
    public void testSubaruForesterEntity() {
        // preset copy #2, with one more argument in front
        CarEntity car = new CarEntity(1L, "Subaru", "Forester", "Blue", null, null, 50000, 5);

        assertEquals(1L, car.getId());
        assertEquals(5, car.getSeats());
        assertEquals(50000, car.getMileage());
    }

    @Test
    public void testHondaFitDto() {
        CarDto car = new CarDto("Honda", "Fit", "White", null, null, null, 4);

        assertEquals("Honda", car.getBrand());
        assertEquals(4, car.getSeats());
    }

    @Test
    public void testHondaFitEntity() {
        CarEntity car = new CarEntity(2L, "Honda", "Fit", null, 2018, null, null, 4);

        assertEquals(2L, car.getId());
        assertEquals(2018, car.getYear());
    }
}
