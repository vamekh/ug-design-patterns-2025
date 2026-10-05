package ge.edu.ug.patterns.structural.proxy.dbservice;

import java.util.ArrayList;
import java.util.List;

// Real Subject: only the business logic is left
public class DbService implements IDbService {
    private final List<String> savedData = new ArrayList<>();

    @Override
    public void saveData(String data) {
        System.out.println("Saving data to database");
        savedData.add(data);
    }

    public List<String> getSavedData() {
        return savedData;
    }
}
