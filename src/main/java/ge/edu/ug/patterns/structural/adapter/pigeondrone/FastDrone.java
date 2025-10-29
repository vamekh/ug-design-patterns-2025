package ge.edu.ug.patterns.structural.adapter.pigeondrone;

public class FastDrone implements DronePost {
    @Override
    public void deliver(Object packg, String address, String message) {
        System.out.printf("FastDrone deliver: %s Package includes: %s. address: %s\n", message, packg, address);
    }
}
