package ge.edu.ug.antipatterns.singletonabuse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Each test builds its own Config - no shared state, no reset(), any order works.
class InvoiceTest {

    private static InvoicePrinter printerFor(Config config) {
        return new InvoicePrinter(config, new InvoiceCalculator(config));
    }

    @Test
    void defaultConfigUsesGelAndVat() {
        assertEquals("Nino: 118.0 GEL", printerFor(new Config("GEL", 0.18)).line("Nino", 100.0));
    }

    @Test
    void usdWithoutTax() {
        assertEquals("John: 100.0 USD", printerFor(new Config("USD", 0.0)).line("John", 100.0));
    }

    @Test
    void calculatorDependencyIsVisible() {
        assertEquals(150.0, new InvoiceCalculator(new Config("GEL", 0.5)).total(100.0), 0.001);
    }

    @Test
    void twoConfigsCanLiveSideBySide() {
        // impossible with a singleton: one global currency for the whole JVM
        InvoicePrinter georgian = printerFor(new Config("GEL", 0.18));
        InvoicePrinter american = printerFor(new Config("USD", 0.0));

        assertEquals("Nino: 118.0 GEL", georgian.line("Nino", 100.0));
        assertEquals("John: 100.0 USD", american.line("John", 100.0));
    }
}
