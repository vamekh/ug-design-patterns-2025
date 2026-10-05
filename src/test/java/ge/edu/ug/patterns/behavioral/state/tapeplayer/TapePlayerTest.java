package ge.edu.ug.patterns.behavioral.state.tapeplayer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TapePlayerTest {

    @Test
    void withoutTapeOnlyRadioWorks() {
        TapePlayer player = new TapePlayer();
        assertEquals("NO_TAPE", player.getStatus());
        assertEquals("No tape", player.pressPlay());
        assertEquals("No tape", player.pressRec());
        assertEquals("No tape to eject", player.eject());
        assertEquals("Playing radio", player.playRadio());
        assertEquals("NO_TAPE", player.getStatus());
    }

    @Test
    void insertPlayStopEject() {
        TapePlayer player = new TapePlayer();
        assertEquals("Tape inserted", player.insertTape());
        assertEquals("STOPPED", player.getStatus());

        assertEquals("Playing from tape", player.pressPlay());
        assertEquals("PLAYING", player.getStatus());
        assertEquals("Stop the tape before ejecting", player.eject());

        assertEquals("Stopped", player.pressStop());
        assertEquals("Tape ejected", player.eject());
        assertEquals("NO_TAPE", player.getStatus());
    }

    @Test
    void recordingBlocksPlayRadioAndEject() {
        TapePlayer player = new TapePlayer();
        player.insertTape();
        assertEquals("Recording started", player.pressRec());
        assertEquals("RECORDING", player.getStatus());

        assertEquals("Recording in progress", player.pressPlay());
        assertEquals("Cannot play radio while recording", player.playRadio());
        assertEquals("Stop recording before ejecting", player.eject());

        assertEquals("Recording stopped", player.pressStop());
        assertEquals("STOPPED", player.getStatus());
    }

    @Test
    void radioStopsPlayback() {
        TapePlayer player = new TapePlayer();
        player.insertTape();
        player.pressPlay();
        assertEquals("Stop playback before recording", player.pressRec());
        assertEquals("Tape stopped, playing radio", player.playRadio());
        assertEquals("STOPPED", player.getStatus());
        assertEquals("Tape already inserted", player.insertTape());
    }
}
