package ge.edu.ug.antipatterns.singletonabuse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

// Deliberately FAILS: the same two scenarios WITHOUT resetting the singleton.
// The first test changes the global config, the second one inherits it and breaks.
// Run with: mvn test -Dsurefire.excludedGroups= -Dgroups=problem-demo
@Tag("problem-demo")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LeakyInvoiceTest {

    @Test
    @Order(1)
    void usdWithoutTax() {
        AppConfig.getInstance().setCurrency("USD");
        AppConfig.getInstance().setTaxRate(0.0);

        assertEquals("John: 100.0 USD", new InvoicePrinter().line("John", 100.0));
    }

    @Test
    @Order(2)
    void defaultConfigUsesGelAndVat() {
        // fails: still USD with 0% tax, left over from the previous test
        assertEquals("Nino: 118.0 GEL", new InvoicePrinter().line("Nino", 100.0));
    }

    @AfterAll
    static void cleanUp() {
        AppConfig.getInstance().reset();
    }
}
