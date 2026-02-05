package ge.edu.ug.patterns.creational.prototype.cars;

import java.util.HashMap;
import java.util.Map;

//Prototype Registry
public class VehicleCache {
    private Map<String, Vehicle> cache = new HashMap<>();

    public VehicleCache() {
        cache.put("sport-car", new Car("Ford", "Mustang", "Blue", "Gasoline", 300));
        cache.put("family-car", new Car("Toyota", "Rav4", "White", "Hybrid", 150));
    }

    public Vehicle getVehicle(String key){
        return cache.get(key).clone();
    }
}
