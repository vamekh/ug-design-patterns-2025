package ge.edu.ug.patterns.creational.prototype.cars;

public class Bus extends Vehicle{
    public int seats;

    public Bus(String brand, String model, String color, String engine, int seats) {
        super(brand, model, color, engine);
        this.seats = seats;
    }

    @Override
    public String toString() {
        return String.format("Bus: %s seats: %d", super.toString(), seats);
    }
}
