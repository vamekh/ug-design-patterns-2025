package ge.edu.ug.solid.srp.employee;

import java.util.Random;

public class IdGenerator {
    public String generateId(String prefix) {
        return prefix + (new Random().nextInt(1000, 10000));
    }
}
