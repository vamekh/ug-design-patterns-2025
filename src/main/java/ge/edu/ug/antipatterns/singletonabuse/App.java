package ge.edu.ug.antipatterns.singletonabuse;

public class App {

    public static void main(String[] args) {
        AppConfig.getInstance().setCurrency("GEL");
        AppConfig.getInstance().setTaxRate(0.18);

        InvoicePrinter printer = new InvoicePrinter();
        System.out.println(printer.line("Nino", 100.0));
    }
}
