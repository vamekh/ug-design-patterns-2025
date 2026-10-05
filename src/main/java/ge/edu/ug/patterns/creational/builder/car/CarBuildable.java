package ge.edu.ug.patterns.creational.builder.car;

// Builder interface: T is the product this builder creates
public interface CarBuildable<T> {

    T build();

    CarBuildable<T> brand(String brand);

    CarBuildable<T> model(String model);

    CarBuildable<T> color(String color);

    CarBuildable<T> year(Integer year);

    CarBuildable<T> price(Integer price);

    CarBuildable<T> mileage(Integer mileage);

    CarBuildable<T> seats(Integer seats);
}
