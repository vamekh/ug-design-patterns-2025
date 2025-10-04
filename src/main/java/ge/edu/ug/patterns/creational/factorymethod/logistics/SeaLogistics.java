package ge.edu.ug.patterns.creational.factorymethod.logistics;

// Concrete Creator
public class SeaLogistics extends Logistics {
    @Override
    protected Transport createTransport() {
        return new Ship();
    }
}
