package ge.edu.ug.solid.isp.printer;

public class AdvancedPrinter implements FaxDevice, PrintDevice, ScannerDevice {
    @Override
    public void print() {
        System.out.println("The advanced printer prints a document.");
    }

    @Override
    public void sendFax() {
        System.out.println("The advanced printer sends a fax.");
    }

    @Override
    public void scan() {
        System.out.println("The advanced printer scans a document.");
    }
}
