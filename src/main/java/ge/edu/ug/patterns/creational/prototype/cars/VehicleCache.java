package ge.edu.ug.patterns.creational.prototype.cars;

import java.util.HashMap;
import java.util.Map;

//Prototype Registry
public class VehicleCache {
    private Map<String, Vehicle> cache = new HashMap<>();

    public VehicleCache() {
        cache.put("sport-car", new Car("Ford", "Mustang", "Blue", new Engine(2000, "Gasoline"), 300));
        cache.put("family-car", new Car("Toyota", "Rav4", "White", new Engine(1500, "Hybrid"), 150));
    }

    public Vehicle getVehicle(String key){
        Vehicle prototype = cache.get(key);
        if (prototype == null) {
            throw new IllegalArgumentException("Unknown vehicle key: " + key);
        }
        return prototype.copy();
    }
}
