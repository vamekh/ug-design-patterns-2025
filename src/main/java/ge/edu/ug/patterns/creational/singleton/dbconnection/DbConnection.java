package ge.edu.ug.patterns.creational.singleton.dbconnection;

// PROBLEM: the constructor is public, so every service opens its own connection.
// A real database allows only a limited number of connections, and each one is expensive to open.
public class DbConnection {
    private static int openedConnections = 0;
    private final int id;

    public DbConnection() {
        openedConnections++;
        id = openedConnections;
        System.out.println("Opening DB connection #" + id);
    }

    public static int getOpenedConnections() {
        return openedConnections;
    }

    public int getId() {
        return id;
    }

    public String query(String sql) {
        return "[connection #" + id + "] " + sql;
    }
}
