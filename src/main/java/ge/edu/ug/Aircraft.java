package ge.edu.ug;

class Aircraft {
    protected AircraftControlTower controlTower;
    protected String callSign;
    protected String type;

    public void send(String event) {
        controlTower.notify(this, event);
    }

    public void receive(String instruction) {
        System.out.println("Aircraft " + type + " with call sign " + callSign + " received an instruction: " + instruction);
        if (instruction.contains("Clear to land")) {
            System.out.println("Aircraft " + type + " with call sign " + callSign + ": reducing speed manually");
        } else if (instruction.contains("You may proceed to ground taxi.")) {
            System.out.println("Aircraft " + type + " with call sign " + callSign + ": leaving runway");
        } else if (instruction.contains("currently busy")) {
            System.out.println("Aircraft " + type + " with call sign " + callSign + ": waiting for runway to be free");
        }
    }

    public Aircraft(AircraftControlTower controlTower, String callSign, String type) {
        this.controlTower = controlTower;
        this.callSign = callSign;
        this.type = type;
    }
}
