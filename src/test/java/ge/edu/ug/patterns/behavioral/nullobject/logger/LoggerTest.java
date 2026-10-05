package ge.edu.ug.patterns.behavioral.nullobject.logger;

import ge.edu.ug.testutil.ConsoleCapture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoggerTest {

    @Test
    void testConsoleLogger() {
        TransactionService service = new TransactionService(new ConsoleLogger());

        String out = ConsoleCapture.run(() -> service.processTransaction("TX12345"));

        assertTrue(out.contains("WARNING: Processing transaction: TX12345"));
        assertTrue(out.contains("WARNING: Transaction completed: TX12345"));
    }

    @Test
    void testErrorIsLogged() {
        TransactionService service = new TransactionService(new ConsoleLogger());

        String out = ConsoleCapture.run(() -> service.processTransaction(null));

        assertTrue(out.contains("ERROR: Transaction ID cannot be null"));
    }

    @Test
    void testWithoutLogger() {
        TransactionService service = new TransactionService();

        String out = ConsoleCapture.run(() -> {
            service.processTransaction("TX12346");
            service.processTransaction(null);
        });

        assertEquals("", out);
    }

    @Test
    void testExplicitNullLogger() {
        TransactionService service = new TransactionService(null);

        String out = ConsoleCapture.run(() -> service.processTransaction("TX12347"));

        assertEquals("", out);
    }

    @Test
    void testNullObjectIsASingleton() {
        assertSame(LoggerNullObject.getInstance(), LoggerNullObject.getInstance());
    }
}
