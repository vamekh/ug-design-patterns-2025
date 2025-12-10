package ge.edu.ug;

import java.util.HashMap;

public class TbilisiAircraftControlTower implements AircraftControlTower {
    private HashMap<String, Aircraft> aircrafts = new HashMap<>();
    private Aircraft runwayOccupant = null;

    @Override
    public void notify(Aircraft sender, String event) {
        if (event.equals("REQUEST_LANDING")) {
            if (runwayOccupant == null) {
                sender.receive("Clear to land on runway 31.");
                runwayOccupant = sender;

                broadcast(sender, "Runway is now occupied by " + sender.callSign);
            } else {
                if (runwayOccupant.equals(sender)) {
                    System.out.println("The plane that already occupies runway cannot request landing");
                } else {
                    sender.receive("Runway is currently busy by " + runwayOccupant.callSign);
                }
            }
        } else if (event.equals("FREE_RUNWAY")) {
            if (runwayOccupant == null) {
                System.out.println("Cannot free runway, since the runway is already free");
            } else {
                if (runwayOccupant.equals(sender)) {
                    sender.receive("Runway clearance confirmed. You may proceed to ground taxi.");
                    broadcast(sender, "Runway 31 is now clear. Next aircraft must re-request landing.");
                    runwayOccupant = null;
                } else {
                    System.out.println("The runway occupied by another aircraft.");
                }
            }
        }
    }

    @Override
    public void registerAircraft(Aircraft aircraft) {
        aircrafts.put(aircraft.callSign, aircraft);
    }

    private void broadcast(Aircraft sender, String message) {
        for (Aircraft aircraft: aircrafts.values()) {
            if (aircraft != sender) {
                aircraft.receive(message);
            }
        }
    }

    public void logCurrentRunwayOccupant() {
        if (runwayOccupant == null) {
            System.out.println("Runway is free.");
        } else {
            System.out.println("Aircraft " + runwayOccupant.type + " with call sign " + runwayOccupant.callSign + ": is now occupying runway 31.");
        }
    }
}
