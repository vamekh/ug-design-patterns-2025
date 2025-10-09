package ge.edu.ug.patterns.creational.builder.car;

public class CarEntity {
    Long id;
    String brand;
    String model;
    String color;
    Integer year;
    Integer price;
    Integer mileage;
    Integer seats;

    public CarEntity(Long id, String brand, String model, String color, Integer year, Integer price, Integer mileage, Integer seats) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
        this.seats = seats;
    }
}
