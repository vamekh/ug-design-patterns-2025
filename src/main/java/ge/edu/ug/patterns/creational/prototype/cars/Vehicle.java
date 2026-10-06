package ge.edu.ug.patterns.creational.prototype.cars;

public abstract class Vehicle implements Prototype {
    public String color;
    public String model;
    public String brand;
    public Engine engine;

    public Vehicle(String brand, String model, String color, Engine engine) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    public Vehicle(Vehicle vehicle) {
        this.brand = vehicle.brand;
        this.model = vehicle.model;
        this.color = vehicle.color;
        this.engine = vehicle.engine.copy();
    }

    @Override
    public abstract Vehicle copy();

    @Override
    public String toString() {
        return String.format("Brand: %s; Model: %s; Color: %s; Engine: %s;", brand, model, color, engine);
    }
}
