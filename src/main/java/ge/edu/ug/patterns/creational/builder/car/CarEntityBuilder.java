package ge.edu.ug.patterns.creational.builder.car;

public class CarEntityBuilder implements CarBuildable{
    String brand;
    String model;
    String color;
    Integer year;
    Integer price;
    Integer mileage;
    Integer seats;

    public CarEntityBuilder() {

    }

    public CarDto build() {
        return new CarDto(brand, model, color, year, price, mileage, seats);
    }

    @Override
    public CarEntityBuilder brand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public CarEntityBuilder model(String model) {
        this.model = model;
        return this;
    }

    @Override
    public CarEntityBuilder color(String color) {
        this.color = color;
        return this;
    }

    @Override
    public CarEntityBuilder year(Integer year) {
        this.year = year;
        return this;
    }

    @Override
    public CarEntityBuilder price(Integer price) {
        this.price = price;
        return this;
    }

    @Override
    public CarEntityBuilder mileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    @Override
    public CarEntityBuilder seats(Integer seats) {
        this.seats = seats;
        return this;
    }
}
