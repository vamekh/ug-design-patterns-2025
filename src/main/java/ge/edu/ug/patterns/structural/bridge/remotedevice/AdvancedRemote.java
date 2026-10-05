package ge.edu.ug.patterns.structural.bridge.remotedevice;

// Refined Abstraction: adds mute on top of the basic controls, for any Device.
public class AdvancedRemote extends Remote {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        device.setVolume(0);
    }
}
