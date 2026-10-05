package ge.edu.ug.patterns.structural.bridge.remotedevice;

public class Tv {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    public boolean isEnabled() {
        return on;
    }

    public void enable() {
        on = true;
    }

    public void disable() {
        on = false;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(100, volume));
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = Math.max(1, Math.min(99, channel));
    }
}
