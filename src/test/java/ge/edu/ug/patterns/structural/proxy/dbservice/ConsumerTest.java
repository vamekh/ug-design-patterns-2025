package ge.edu.ug.patterns.structural.proxy.dbservice;

import ge.edu.ug.testutil.ConsoleCapture;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

// PROBLEM: auth, console logging and kafka logging are welded into DbService.saveData.
// We cannot save without kafka logging, change the logging order or reuse the token
// check for another service - each of these means editing DbService.
class ConsumerTest {

    @Test
    void testConsumer() {
        DbService service = new DbService("secret-token");
        Consumer consumer = new Consumer(service);

        String out = ConsoleCapture.run(() -> consumer.saveData("Test data"));

        int console = out.indexOf("logging info to console logging system");
        int kafka = out.indexOf("logging info to kafka");
        int save = out.indexOf("Saving data to database");
        assertTrue(console >= 0 && console < kafka && kafka < save);
        assertEquals(List.of("Test data"), service.getSavedData());
    }

    @Test
    void testInvalidTokenIsRejected() {
        DbService service = new DbService("wrong-token");
        Consumer consumer = new Consumer(service);

        assertThrows(SecurityException.class, () -> consumer.saveData("Test data"));
        assertTrue(service.getSavedData().isEmpty());
    }
}
