package ge.edu.ug.patterns.creational.singleton.dbconnection;

import java.util.Random;

public class DbConnection {
    private static volatile DbConnection singletonInstance;
    private Integer id;

    private DbConnection() {
        id = new Random().nextInt(1, 1000);
    }

    public static DbConnection getInstance() {
        if (singletonInstance == null) {
            synchronized (DbConnection.class) {
                singletonInstance = new DbConnection();
            }
        }
        
        return singletonInstance;
    }

    public void connect() {
        System.out.println("Connected to DB");
    }

    public void ping() {
        System.out.println("Pinging DB by instance: " + id);
    }
}
