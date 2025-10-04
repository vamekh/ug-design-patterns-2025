package ge.edu.ug.solid.isp.printer;

public class BasicPrinter implements Printer{
    @Override
    public void print() {
        System.out.println("Printing...");
    }
    @Override
    public void sendFax() {
        throw new UnsupportedOperationException("Faxing is not supported by this printer");
    }
}
