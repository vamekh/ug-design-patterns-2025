package ge.edu.ug.patterns.creational.builder.car;

// Concrete Builder
public class CarDtoBuilder implements CarBuildable<CarDto> {
    private String brand;
    private String model;
    private String color;
    private Integer year;
    private Integer price;
    private Integer mileage;
    private Integer seats;

    @Override
    public CarDto build() {
        return new CarDto(brand, model, color, year, price, mileage, seats);
    }

    @Override
    public CarDtoBuilder brand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public CarDtoBuilder model(String model) {
        this.model = model;
        return this;
    }

    @Override
    public CarDtoBuilder color(String color) {
        this.color = color;
        return this;
    }

    @Override
    public CarDtoBuilder year(Integer year) {
        this.year = year;
        return this;
    }

    @Override
    public CarDtoBuilder price(Integer price) {
        this.price = price;
        return this;
    }

    @Override
    public CarDtoBuilder mileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    @Override
    public CarDtoBuilder seats(Integer seats) {
        this.seats = seats;
        return this;
    }
}
