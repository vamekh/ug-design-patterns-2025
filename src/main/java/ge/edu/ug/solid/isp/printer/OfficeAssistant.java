package ge.edu.ug.solid.isp.printer;

// Client that only prints: depends on Printer alone, so any printer (even a basic one) fits.
public class OfficeAssistant {
    private final Printer printer;

    public OfficeAssistant(Printer printer) {
        this.printer = printer;
    }

    public String printReport() {
        return printer.print();
    }
}
