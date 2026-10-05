package ge.edu.ug.patterns.structural.bridge.remotedevice;

public class AdvancedRadioRemote {
    protected final Radio device;

    public AdvancedRadioRemote(Radio device) {
        this.device = device;
    }

    public void togglePower() {
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    public void volumeUp() {
        device.setVolume(device.getVolume() + 10);
    }

    public void volumeDown() {
        device.setVolume(device.getVolume() - 10);
    }

    public void channelUp() {
        device.setChannel(device.getChannel() + 1);
    }

    public void channelDown() {
        device.setChannel(device.getChannel() - 1);
    }

    public void mute() {
        device.setVolume(0);
    }
}
