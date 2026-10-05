package ge.edu.ug.antipatterns.singletonabuse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// All tests share ONE AppConfig. Without the manual reset below, a test that switches to USD
// leaks into whichever test runs next, and results depend on test order (see LeakyInvoiceTest).
// The reset() method exists in production code only to make these tests possible.
class InvoiceTest {

    @BeforeEach
    void resetGlobalState() {
        AppConfig.getInstance().reset(); // forget this line and tests start failing "randomly"
    }

    @Test
    void defaultConfigUsesGelAndVat() {
        assertEquals("Nino: 118.0 GEL", new InvoicePrinter().line("Nino", 100.0));
    }

    @Test
    void usdWithoutTax() {
        AppConfig.getInstance().setCurrency("USD");
        AppConfig.getInstance().setTaxRate(0.0);

        assertEquals("John: 100.0 USD", new InvoicePrinter().line("John", 100.0));
    }

    @Test
    void calculatorSecretlyReadsTheGlobal() {
        // new InvoiceCalculator() looks dependency-free, yet its result changes with global state
        AppConfig.getInstance().setTaxRate(0.5);

        assertEquals(150.0, new InvoiceCalculator().total(100.0), 0.001);
    }
}
