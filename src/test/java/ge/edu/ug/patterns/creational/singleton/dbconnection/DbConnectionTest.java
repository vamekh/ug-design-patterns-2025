package ge.edu.ug.patterns.creational.singleton.dbconnection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DbConnectionTest {
    @Test
    public void testDbConnection() {
        DbConnection connection = DbConnection.getInstance();
        connection.connect();
        connection.ping();

        DbConnection connection2 = DbConnection.getInstance();
        connection2.connect();
        connection2.ping();
        assertNotNull(connection);
    }

}
