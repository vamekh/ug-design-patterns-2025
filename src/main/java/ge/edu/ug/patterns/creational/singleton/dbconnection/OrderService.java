package ge.edu.ug.patterns.creational.singleton.dbconnection;

public class OrderService {
    private final DbConnection connection = new DbConnection();

    public String findOrders(String userName) {
        return connection.query("SELECT * FROM orders WHERE user = '" + userName + "'");
    }

    public DbConnection getConnection() {
        return connection;
    }
}
