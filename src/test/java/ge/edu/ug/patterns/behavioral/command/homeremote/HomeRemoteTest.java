package ge.edu.ug.patterns.behavioral.command.homeremote;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HomeRemoteTest {
    private static final int OPEN_DOOR = 0, CLOSE_DOOR = 1, LIGHT_ON = 2, LIGHT_OFF = 3, LEAVE_HOME = 4;

    private DoorEngine garageDoor;
    private SmartLightBulb garageLight;
    private HomeRemote remote;

    @BeforeEach
    void setUp() {
        garageDoor = new DoorEngine();
        garageLight = new SmartLightBulb();
        remote = new HomeRemote(6);
        remote.setCommand(OPEN_DOOR, new DoorOpenCommand(garageDoor));
        remote.setCommand(CLOSE_DOOR, new DoorCloseCommand(garageDoor));
        remote.setCommand(LIGHT_ON, new LightOnCommand(garageLight));
        remote.setCommand(LIGHT_OFF, new LightOffCommand(garageLight));
        remote.setCommand(LEAVE_HOME, new MacroCommand(List.of(
                new LightOffCommand(garageLight), new DoorCloseCommand(garageDoor))));
    }

    @Test
    void buttonsDriveTheDevices() {
        remote.press(OPEN_DOOR);
        remote.press(LIGHT_ON);
        assertTrue(garageDoor.isOpen());
        assertTrue(garageLight.isOn());

        remote.press(LEAVE_HOME);
        assertFalse(garageDoor.isOpen());
        assertFalse(garageLight.isOn());
    }

    @Test
    void undoLastReversesPressesInOrder() {
        remote.press(OPEN_DOOR);
        remote.press(LIGHT_ON);

        remote.undoLast();
        assertFalse(garageLight.isOn());
        assertTrue(garageDoor.isOpen());

        remote.undoLast();
        assertFalse(garageDoor.isOpen());
        assertDoesNotThrow(remote::undoLast); // empty history is fine
    }

    @Test
    void undoingAMacroRestoresEverything() {
        remote.press(OPEN_DOOR);
        remote.press(LIGHT_ON);
        remote.press(LEAVE_HOME);

        remote.undoLast();
        assertTrue(garageDoor.isOpen());
        assertTrue(garageLight.isOn());
    }

    @Test
    void emptySlotIsANoCommand() {
        assertDoesNotThrow(() -> remote.press(5));
    }

    @Test
    void reassigningAButtonNeedsNoRemoteChange() {
        DoorEngine yardBarrier = new DoorEngine();
        remote.setCommand(OPEN_DOOR, new DoorOpenCommand(yardBarrier));

        remote.press(OPEN_DOOR);
        assertTrue(yardBarrier.isOpen());
        assertFalse(garageDoor.isOpen());
    }
}
