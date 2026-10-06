package ge.edu.ug.patterns.creational.prototype.cars;

public class Engine implements Prototype{
    public int volume;
    public String type;

    public Engine(int volume, String type) {
        this.volume = volume;
        this.type = type;
    }

    public Engine(Engine engine) {
        this.volume = engine.volume;
        this.type = engine.type;
    }

    @Override
    public Engine copy() {
        return new Engine(this);
    }

    @Override
    public String toString() {
        return String.format("Engine volume: %d, type: %s", volume, type);
    }
}
