package ge.edu.ug.patterns.structural.bridge.remotedevice;

// Implementor: what every device can do; remotes only talk to this interface.
public interface Device {
    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int volume);

    int getChannel();

    void setChannel(int channel);
}
