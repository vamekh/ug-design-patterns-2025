package ge.edu.ug.patterns.creational.builder.car;

public class CarDtoBuilder implements CarBuildable{
    String brand;
    String model;
    String color;
    Integer year;
    Integer price;
    Integer mileage;
    Integer seats;

    public CarDtoBuilder() {

    }

    public CarDto build() {
        return new CarDto(brand, model, color, year, price, mileage, seats);
    }

    public CarDtoBuilder brand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarDtoBuilder model(String model) {
        this.model = model;
        return this;
    }
    public CarDtoBuilder color(String color) {
        this.color = color;
        return this;
    }
    public CarDtoBuilder year(Integer year) {
        this.year = year;
        return this;
    }
    public CarDtoBuilder price(Integer price) {
        this.price = price;
        return this;
    }
    public CarDtoBuilder mileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }
    public CarDtoBuilder seats(Integer seats) {
        this.seats = seats;
        return this;
    }
}
