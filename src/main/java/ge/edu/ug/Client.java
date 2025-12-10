package ge.edu.ug;

public class Client {
    public static void main(String[] args) {
        TbilisiAircraftControlTower tbilisiControlTower = new TbilisiAircraftControlTower();
        Aircraft boeing747 = new Aircraft(tbilisiControlTower, "DAL890", "BOEING747");
        Aircraft airbus380 = new Aircraft(tbilisiControlTower, "UAE238", "AIRBUS380");
        Aircraft boeing777 = new Aircraft(tbilisiControlTower, "GE352", "BOEING777");

        tbilisiControlTower.registerAircraft(boeing747);
        tbilisiControlTower.registerAircraft(airbus380);
        tbilisiControlTower.registerAircraft(boeing777);

        boeing747.send("REQUEST_LANDING");

        System.out.println();
        tbilisiControlTower.logCurrentRunwayOccupant();
        System.out.println();

        airbus380.send("REQUEST_LANDING");

        System.out.println();
        tbilisiControlTower.logCurrentRunwayOccupant();
        System.out.println();

        boeing747.send("FREE_RUNWAY");

        System.out.println();
        tbilisiControlTower.logCurrentRunwayOccupant();
        System.out.println();

        boeing747.send("FREE_RUNWAY");
        System.out.println();
        airbus380.send("FREE_RUNWAY");
        System.out.println();

        airbus380.send("REQUEST_LANDING");
        System.out.println();
        airbus380.send("REQUEST_LANDING");
        System.out.println();
        boeing777.send("REQUEST_LANDING");
        System.out.println();
        airbus380.send("FREE_RUNWAY");
        System.out.println();
        tbilisiControlTower.logCurrentRunwayOccupant();
        System.out.println();
        boeing777.send("REQUEST_LANDING");
    }
}
