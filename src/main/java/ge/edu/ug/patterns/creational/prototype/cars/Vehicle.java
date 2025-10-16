package ge.edu.ug.patterns.creational.prototype.cars;

public abstract class Vehicle implements Prototype  {
    public String isClone = "";
    public String engineType;
    public String color;
    public String model;
    public String brand;

    public Vehicle(String brand, String model, String color, String engineType) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.engineType = engineType;
    }

    public Vehicle(Vehicle vehicle) {
        this.brand = vehicle.brand;
        this.model = vehicle.model;
        this.color = vehicle.color;
        this.engineType = vehicle.engineType;
        this.isClone = " (Cloned)";
    }

    @Override
    public abstract Vehicle clone();

    @Override
    public String toString() {
        return String.format(isClone + "Brand: %s; Model: %s; Color: %s; Engine: %s;", brand, model, color, engineType);
    }
}
