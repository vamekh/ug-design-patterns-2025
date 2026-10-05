package ge.edu.ug.antipatterns.singletonabuse;

// Composition root: the ONLY place that decides which Config the application runs with.
public class App {

    public static void main(String[] args) {
        Config config = new Config("GEL", 0.18);

        InvoicePrinter printer = new InvoicePrinter(config, new InvoiceCalculator(config));
        System.out.println(printer.line("Nino", 100.0));
    }
}
