package ge.edu.ug.patterns.creational.builder.car;

// Concrete Builder
public class CarEntityBuilder implements CarBuildable<CarEntity> {
    private Long id;
    private String brand;
    private String model;
    private String color;
    private Integer year;
    private Integer price;
    private Integer mileage;
    private Integer seats;

    @Override
    public CarEntity build() {
        return new CarEntity(id, brand, model, color, year, price, mileage, seats);
    }

    public CarEntityBuilder id(Long id) {
        this.id = id;
        return this;
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
