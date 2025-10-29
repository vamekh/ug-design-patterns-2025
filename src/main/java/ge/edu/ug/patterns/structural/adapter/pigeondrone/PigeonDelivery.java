package ge.edu.ug.patterns.structural.adapter.pigeondrone;

public class PigeonDelivery implements BirdPost {
    @Override
    public void deliver(String address, String message) {
        System.out.printf("Delivering %s to %s....\n", message, address);
        System.out.println("Flying....");
        System.out.println("Flying....");
        System.out.println("Flying....");
    }
}
