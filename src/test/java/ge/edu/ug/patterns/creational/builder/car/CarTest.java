package ge.edu.ug.patterns.creational.builder.car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

// Builder: only the known values are set, by name.
// Director: each popular model preset is written once and reused for CarDto and CarEntity.
class CarTest {

    PopularModelsDirector director = new PopularModelsDirector();

    @Test
    public void testCustomCar() {
        CarDto car = new CarDtoBuilder()
                .brand("Honda")
                .model("Fit")
                .year(2014)
                .build();

        assertEquals(2014, car.getYear());
        assertNull(car.getPrice());
    }

    @Test
    public void testSubaruForesterDto() {
        CarDto car = director.buildSubaruForester(new CarDtoBuilder())
                .color("Red")
                .build();

        assertEquals("Forester", car.getModel());
        assertEquals(5, car.getSeats());
        assertEquals("Red", car.getColor());
    }

    @Test
    public void testSubaruForesterEntity() {
        CarEntity car = director.buildSubaruForester(new CarEntityBuilder().id(1L))
                .color("Blue")
                .mileage(50000)
                .build();

        assertEquals(1L, car.getId());
        assertEquals(5, car.getSeats());
        assertEquals(50000, car.getMileage());
    }

    @Test
    public void testHondaFitDto() {
        CarDto car = director.buildHondaFit(new CarDtoBuilder())
                .color("White")
                .build();

        assertEquals("Honda", car.getBrand());
        assertEquals(4, car.getSeats());
    }

    @Test
    public void testHondaFitEntity() {
        CarEntity car = director.buildHondaFit(new CarEntityBuilder().id(2L))
                .year(2018)
                .build();

        assertEquals(2L, car.getId());
        assertEquals(2018, car.getYear());
    }
}
