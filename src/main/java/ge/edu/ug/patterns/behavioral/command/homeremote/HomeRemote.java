package ge.edu.ug.patterns.behavioral.command.homeremote;

// PROBLEM: the remote knows every device class and has one hard-wired method per button.
// Adding a device (or re-assigning a button) means editing HomeRemote; a "leaving home"
// button needs yet another method, and there is no way to undo the last press.
public class HomeRemote {
    private final DoorEngine garageDoor;
    private final SmartLightBulb garageLight;

    public HomeRemote(DoorEngine garageDoor, SmartLightBulb garageLight) {
        this.garageDoor = garageDoor;
        this.garageLight = garageLight;
    }

    public void openGarageDoor() {
        garageDoor.open();
    }

    public void closeGarageDoor() {
        garageDoor.close();
    }

    public void switchOnGarageLight() {
        garageLight.switchOn();
    }

    public void switchOffGarageLight() {
        garageLight.switchOff();
    }

    public void leaveHome() {
        garageLight.switchOff();
        garageDoor.close();
    }
}
