package ge.edu.ug.patterns.structural.bridge.remotedevice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// PROBLEM: every combination of remote and device is its own class, so the tests
// (and the code) repeat the same scenario for BasicTvRemote, BasicRadioRemote,
// AdvancedTvRemote and AdvancedRadioRemote. There is no way to pass "any device" to a remote.
class RemoteTest {

    @Test
    void basicRemoteControlsTv() {
        Tv tv = new Tv();
        BasicTvRemote remote = new BasicTvRemote(tv);
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
        BasicRadioRemote remote = new BasicRadioRemote(radio);
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
        AdvancedTvRemote remote = new AdvancedTvRemote(tv);
        remote.togglePower();
        remote.mute();

        assertEquals(0, tv.getVolume());
    }

    @Test
    void advancedRemoteMutesRadio() {
        Radio radio = new Radio();
        AdvancedRadioRemote remote = new AdvancedRadioRemote(radio);
        remote.togglePower();
        remote.togglePower();
        remote.mute();

        assertFalse(radio.isEnabled());
        assertEquals(0, radio.getVolume());
    }
}
