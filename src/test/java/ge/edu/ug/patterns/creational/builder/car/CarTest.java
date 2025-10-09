package ge.edu.ug.patterns.creational.builder.car;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    public void testCar() {
        CarDto car1 = new CarDto("Honda", "Fit", null, 2014, null, null, null);

        CarDto car2 = new CarDtoBuilder()
                .brand("Subaru")
                .model("Forester")
                .color("Blue")
                .mileage(50000)
                .build();

        PopularModelsDirector director = new PopularModelsDirector();
        CarDtoBuilder builder = new CarDtoBuilder();
        director.buildSubaruForester( builder)
                .color("Red");
        builder.build();

    }

}
