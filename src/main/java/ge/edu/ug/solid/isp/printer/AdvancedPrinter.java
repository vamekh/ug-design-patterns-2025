package ge.edu.ug.solid.isp.printer;

public class AdvancedPrinter implements Printer, Fax {
    @Override
    public String print() {
        return "The advanced printer prints a document.";
    }

    @Override
    public String sendFax() {
        return "The advanced printer sends a fax.";
    }
}
