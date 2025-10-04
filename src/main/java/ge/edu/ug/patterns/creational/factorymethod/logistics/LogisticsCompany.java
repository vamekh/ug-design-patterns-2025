package ge.edu.ug.patterns.creational.factorymethod.logistics;

import java.util.Objects;

public class LogisticsCompany {
    public void deliver(String destination, String cargo){
        Transport transport;
        if (Objects.equals(destination, "overseas")) {
            transport = new Ship();
        } else {
            transport = new Truck();
        }
        transport.deliver(cargo);
    }
}
