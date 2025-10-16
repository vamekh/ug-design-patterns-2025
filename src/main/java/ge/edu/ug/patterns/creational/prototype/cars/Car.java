package ge.edu.ug.patterns.creational.prototype.cars;

public class Car extends Vehicle{
    public int topSpeed;

    public Car(String brand, String model, String color, String engine, int topSpeed) {
        super(brand, model, color, engine);
        this.topSpeed = topSpeed;
    }

    public Car(Car car) {
        super(car);
        this.topSpeed = car.topSpeed;
    }

    @Override
    public Vehicle clone() {
        return new Car(this);
    }

    @Override
    public String toString() {
        return String.format("Car: %s Top speed: %d", super.toString(), topSpeed);
    }
}
