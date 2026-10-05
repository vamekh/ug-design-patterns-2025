package ge.edu.ug.patterns.structural.proxy.dbservice;

import ge.edu.ug.testutil.ConsoleCapture;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Proxy: auth and logging are separate proxies around DbService. They are stacked
// in any order (or left out) when the object graph is built; DbService never changes.
class ConsumerTest {

    @Test
    void testConsumer() {
        DbService service = new DbService();
        Consumer consumer = new Consumer(
                new TokenProxy(
                        new DbServiceConsoleLoggingProxy(
                                new DbServiceKafkaLoggingProxy(service)),
                        "secret-token"));

        String out = ConsoleCapture.run(() -> consumer.saveData("Test data"));

        int console = out.indexOf("logging info to console logging system");
        int kafka = out.indexOf("logging info to kafka");
        int save = out.indexOf("Saving data to database");
        assertTrue(console >= 0 && console < kafka && kafka < save);
        assertEquals(List.of("Test data"), service.getSavedData());
    }

    @Test
    void testInvalidTokenIsRejected() {
        DbService service = new DbService();
        Consumer consumer = new Consumer(
                new TokenProxy(
                        new DbServiceConsoleLoggingProxy(
                                new DbServiceKafkaLoggingProxy(service)),
                        "wrong-token"));

        String out = ConsoleCapture.run(
                () -> assertThrows(SecurityException.class, () -> consumer.saveData("Test data")));

        assertTrue(service.getSavedData().isEmpty());   // never reached DbService
        assertFalse(out.contains("logging info"));      // nor the logging proxies behind the TokenProxy
    }

    @Test
    void testProxiesCanBeReorderedOrLeftOut() {
        DbService service = new DbService();
        Consumer consumer = new Consumer(
                new DbServiceKafkaLoggingProxy(service));   // no console logging, no auth

        String out = ConsoleCapture.run(() -> consumer.saveData("Test data"));

        assertTrue(out.indexOf("logging info to kafka") < out.indexOf("Saving data to database"));
        assertFalse(out.contains("console logging system"));
        assertEquals(List.of("Test data"), service.getSavedData());
    }
}
