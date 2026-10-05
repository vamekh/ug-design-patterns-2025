package ge.edu.ug.patterns.creational.singleton.dbconnection;

public class UserService {
    private final DbConnection connection = DbConnection.getInstance();

    public String findUser(String name) {
        return connection.query("SELECT * FROM users WHERE name = '" + name + "'");
    }

    public DbConnection getConnection() {
        return connection;
    }
}
