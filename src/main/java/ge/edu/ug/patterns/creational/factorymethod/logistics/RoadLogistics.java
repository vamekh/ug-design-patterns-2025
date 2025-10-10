package ge.edu.ug.patterns.creational.factorymethod.logistics;

//Concrete Creator
public class RoadLogistics implements Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
