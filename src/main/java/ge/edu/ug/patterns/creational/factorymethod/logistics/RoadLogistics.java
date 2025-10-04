package ge.edu.ug.patterns.creational.factorymethod.logistics;

// Concrete Creator
public class RoadLogistics extends Logistics {
    @Override
    protected Transport createTransport() {
        return new Truck();
    }
}
