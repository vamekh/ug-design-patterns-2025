package ge.edu.ug.patterns.creational.builder.car;

public class CarDto {
    String brand;
    String model;
    String color;
    Integer year;
    Integer price;
    Integer mileage;
    Integer seats;

    protected CarDto(String brand, String model, String color, Integer year, Integer price, Integer mileage, Integer seats) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
        this.seats = seats;
    }
}
