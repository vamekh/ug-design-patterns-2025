package ge.edu.ug.patterns.creational.factorymethod.logistics;

//Concrete Creator
public class SeaLogistics implements Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
