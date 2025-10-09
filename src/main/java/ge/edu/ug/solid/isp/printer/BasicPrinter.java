package ge.edu.ug.solid.isp.printer;

public class BasicPrinter implements PrintDevice{
    @Override
    public void print() {
        System.out.println("Printing...");
    }
}
