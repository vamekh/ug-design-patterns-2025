package ge.edu.ug.patterns.creational.singleton.dbconnection;

public class UserService {
    private final DbConnection connection = new DbConnection();

    public String findUser(String name) {
        return connection.query("SELECT * FROM users WHERE name = '" + name + "'");
    }

    public DbConnection getConnection() {
        return connection;
    }
}
