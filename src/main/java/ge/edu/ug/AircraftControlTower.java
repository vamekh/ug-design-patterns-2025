package ge.edu.ug;

public interface AircraftControlTower {
    void notify(Aircraft sender, String event);
    void registerAircraft(Aircraft aircraft);
}
