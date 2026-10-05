package ge.edu.ug.patterns.creational.builder.car;

// Product (built by CarDtoBuilder)
public class CarDto {
    private final String brand;
    private final String model;
    private final String color;
    private final Integer year;
    private final Integer price;
    private final Integer mileage;
    private final Integer seats;

    CarDto(String brand, String model, String color, Integer year, Integer price, Integer mileage, Integer seats) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
        this.seats = seats;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Integer getSeats() {
        return seats;
    }
}
