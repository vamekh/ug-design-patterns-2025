package ge.edu.ug.patterns.creational.prototype.cars;

public abstract class Vehicle implements Prototype {
    private String engineType;
    private String color;
    private String model;
    private String brand;

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
    }

    @Override
    public abstract Vehicle copy();

    public String getEngineType() {
        return engineType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return String.format("Brand: %s; Model: %s; Color: %s; Engine: %s;", brand, model, color, engineType);
    }
}
