package ge.edu.ug.patterns.creational.singleton.dbconnection;

// Singleton: private constructor + one lazily created, shared instance
public class DbConnection {
    private static volatile DbConnection instance;
    private static int openedConnections = 0;
    private final int id;

    private DbConnection() {
        openedConnections++;
        id = openedConnections;
        System.out.println("Opening DB connection #" + id);
    }

    // double-checked locking: lock only on first access, check again inside the lock
    public static DbConnection getInstance() {
        if (instance == null) {
            synchronized (DbConnection.class) {
                if (instance == null) {
                    instance = new DbConnection();
                }
            }
        }
        return instance;
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
