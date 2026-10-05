package ge.edu.ug.patterns.behavioral.command.homeremote;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// PROBLEM: every button is a method on HomeRemote bound to one concrete device.
// Undo has to be done by the caller, who must know which opposite method to call.
class HomeRemoteTest {

    @Test
    void buttonsDriveTheDevices() {
        DoorEngine garageDoor = new DoorEngine();
        SmartLightBulb garageLight = new SmartLightBulb();
        HomeRemote remote = new HomeRemote(garageDoor, garageLight);

        remote.openGarageDoor();
        remote.switchOnGarageLight();
        assertTrue(garageDoor.isOpen());
        assertTrue(garageLight.isOn());

        remote.leaveHome();
        assertFalse(garageDoor.isOpen());
        assertFalse(garageLight.isOn());
    }

    @Test
    void undoIsTheCallersJob() {
        DoorEngine garageDoor = new DoorEngine();
        HomeRemote remote = new HomeRemote(garageDoor, new SmartLightBulb());

        remote.openGarageDoor();
        // no remote.undoLast(): we must remember what was pressed and call the opposite ourselves
        remote.closeGarageDoor();
        assertFalse(garageDoor.isOpen());
    }
}
