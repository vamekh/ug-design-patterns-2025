package ge.edu.ug.patterns.creational.singleton.dbconnection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

// Singleton: every service gets the same DbConnection through DbConnection.getInstance(),
// so only one connection is ever opened - even when many threads ask at the same time.
class DbConnectionTest {

    @Test
    public void testServicesShareOneConnection() {
        UserService userService = new UserService();
        OrderService orderService = new OrderService();

        assertSame(userService.getConnection(), orderService.getConnection());
        assertEquals(userService.getConnection().getId(), orderService.getConnection().getId());
    }

    @Test
    public void testNoNewConnectionPerServiceInstance() {
        DbConnection.getInstance();
        int before = DbConnection.getOpenedConnections();

        new UserService().findUser("nino");
        new UserService().findUser("giorgi");
        new OrderService().findOrders("nino");

        assertEquals(before, DbConnection.getOpenedConnections());
        assertEquals(1, DbConnection.getOpenedConnections());
    }

    @Test
    public void testAllThreadsGetTheSameInstance() throws Exception {
        int threads = 20;
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        CountDownLatch start = new CountDownLatch(1);
        Callable<DbConnection> task = () -> {
            start.await();          // release all threads at once
            return DbConnection.getInstance();
        };
        List<Future<DbConnection>> results = new ArrayList<>();
        for (int i = 0; i < threads; i++) {
            results.add(executor.submit(task));
        }

        start.countDown();
        DbConnection expected = DbConnection.getInstance();
        for (Future<DbConnection> result : results) {
            assertSame(expected, result.get());
        }
        executor.shutdown();
        assertEquals(1, DbConnection.getOpenedConnections());
    }
}
