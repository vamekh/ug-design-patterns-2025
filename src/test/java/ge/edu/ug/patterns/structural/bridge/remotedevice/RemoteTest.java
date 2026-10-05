package ge.edu.ug.patterns.structural.bridge.remotedevice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoteTest {

    @Test
    void basicRemoteControlsTv() {
        Tv tv = new Tv();
        BasicRemote remote = new BasicRemote(tv);
        remote.togglePower();
        remote.volumeUp();
        remote.channelUp();

        assertTrue(tv.isEnabled());
        assertEquals(40, tv.getVolume());
        assertEquals(2, tv.getChannel());
    }

    @Test
    void basicRemoteControlsRadio() {
        Radio radio = new Radio();
        BasicRemote remote = new BasicRemote(radio);
        remote.togglePower();
        remote.volumeDown();
        remote.channelDown(); // already at channel 1

        assertTrue(radio.isEnabled());
        assertEquals(20, radio.getVolume());
        assertEquals(1, radio.getChannel());
    }

    @Test
    void advancedRemoteMutesTv() {
        Tv tv = new Tv();
        AdvancedRemote remote = new AdvancedRemote(tv);
        remote.togglePower();
        remote.mute();

        assertEquals(0, tv.getVolume());
    }

    @Test
    void advancedRemoteMutesRadio() {
        Radio radio = new Radio();
        AdvancedRemote remote = new AdvancedRemote(radio);
        remote.togglePower();
        remote.togglePower();
        remote.mute();

        assertFalse(radio.isEnabled());
        assertEquals(0, radio.getVolume());
    }

    @Test
    void newDeviceWorksWithEveryRemote() {
        // SmartSpeaker is one new class; both remotes control it with no other change.
        SmartSpeaker speaker = new SmartSpeaker();
        new BasicRemote(speaker).togglePower();
        AdvancedRemote advanced = new AdvancedRemote(speaker);
        for (int i = 0; i < 15; i++) {
            advanced.channelUp();
        }
        advanced.mute();

        assertTrue(speaker.isEnabled());
        assertEquals(10, speaker.getChannel()); // SmartSpeaker has 10 presets
        assertEquals(0, speaker.getVolume());
    }
}
