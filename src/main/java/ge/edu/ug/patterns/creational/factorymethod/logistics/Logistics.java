package ge.edu.ug.patterns.creational.factorymethod.logistics;

// Creator: owns the delivery logic, subclasses decide which Transport it uses
public abstract class Logistics {
    // Factory method
    protected abstract Transport createTransport();

    public String planDelivery(String destination, String cargo) {
        Transport transport = createTransport();
        String report = transport.deliver(destination, cargo);
        System.out.println(report);
        return report;
    }
}
