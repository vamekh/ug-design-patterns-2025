package ge.edu.ug.patterns.structural.proxy.dbservice;

import java.util.ArrayList;
import java.util.List;

// PROBLEM: the business method also does security and two kinds of logging.
// Logging and auth cannot be turned off, reordered or reused for other services
// without editing DbService, and saving cannot be tested without them.
public class DbService {
    private static final String VALID_TOKEN = "secret-token";

    private final String token;
    private final List<String> savedData = new ArrayList<>();

    public DbService(String token) {
        this.token = token;
    }

    public void saveData(String data) {
        if (!VALID_TOKEN.equals(token)) {
            throw new SecurityException("Invalid token");
        }
        System.out.println("logging info to console logging system");
        System.out.println("logging info to kafka");

        System.out.println("Saving data to database");
        savedData.add(data);
    }

    public List<String> getSavedData() {
        return savedData;
    }
}
