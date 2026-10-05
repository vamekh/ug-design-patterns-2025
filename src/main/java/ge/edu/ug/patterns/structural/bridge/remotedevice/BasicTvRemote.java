package ge.edu.ug.patterns.structural.bridge.remotedevice;

// PROBLEM: one remote class per (remote kind x device) pair: BasicTvRemote, BasicRadioRemote,
// AdvancedTvRemote, AdvancedRadioRemote. The power/volume/channel code is copy-pasted into all four.
// A new device (SmartSpeaker) needs two more classes; a new remote kind needs one per device (n x m).
public class BasicTvRemote {
    protected final Tv device;

    public BasicTvRemote(Tv device) {
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
}
