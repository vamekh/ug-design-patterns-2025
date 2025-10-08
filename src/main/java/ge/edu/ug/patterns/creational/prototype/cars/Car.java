package ge.edu.ug.patterns.creational.prototype.cars;

public class Car extends Vehicle{
    public int topSpeed;

    public Car(String brand, String model, String color, String engine, int topSpeed) {
        super(brand, model, color, engine);
        this.topSpeed = topSpeed;
    }

    @Override
    public String toString() {
        return String.format("Car: %s Top speed: %d", super.toString(), topSpeed);
    }
}
