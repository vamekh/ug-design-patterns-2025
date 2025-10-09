package ge.edu.ug.patterns.creational.builder.car;

public interface CarBuildable<T> {

    public T build();

    public CarBuildable brand(String brand);

    public CarBuildable model(String model);

    public CarBuildable color(String color);

    public CarBuildable year(Integer year);

    public CarBuildable price(Integer price);

    public CarBuildable mileage(Integer mileage);

    public CarBuildable seats(Integer seats);
}
