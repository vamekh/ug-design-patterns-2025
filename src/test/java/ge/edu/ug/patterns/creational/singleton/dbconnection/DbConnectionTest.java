package ge.edu.ug.patterns.creational.singleton.dbconnection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

// PROBLEM: each service creates its own DbConnection, so the application opens
// one connection per service (and per service instance) instead of sharing one.
class DbConnectionTest {

    @Test
    public void testServicesOpenDifferentConnections() {
        UserService userService = new UserService();
        OrderService orderService = new OrderService();

        assertNotSame(userService.getConnection(), orderService.getConnection());
        assertNotEquals(userService.getConnection().getId(), orderService.getConnection().getId());
    }

    @Test
    public void testEveryServiceInstanceOpensAConnection() {
        int before = DbConnection.getOpenedConnections();

        new UserService().findUser("nino");
        new UserService().findUser("giorgi");
        new OrderService().findOrders("nino");

        assertEquals(before + 3, DbConnection.getOpenedConnections());
    }
}
