package ge.edu.ug.patterns.behavioral.state.tapeplayer;

// PROBLEM: three booleans encode four real states (no tape, stopped, playing, recording),
// and every button re-checks them with its own if-chain. Nothing stops an impossible combination
// such as playing && recording, and a new mode (e.g. rewinding) means touching every method.
public class TapePlayer {
    private boolean tapePresent = false;
    private boolean playing = false;
    private boolean recording = false;

    public String insertTape() {
        if (tapePresent) return "Tape already inserted";
        tapePresent = true;
        return "Tape inserted";
    }

    public String eject() {
        if (!tapePresent) return "No tape to eject";
        if (playing) return "Stop the tape before ejecting";
        if (recording) return "Stop recording before ejecting";
        tapePresent = false;
        return "Tape ejected";
    }

    public String pressPlay() {
        if (!tapePresent) return "No tape";
        if (recording) return "Recording in progress";
        if (playing) return "Already playing";
        playing = true;
        return "Playing from tape";
    }

    public String pressStop() {
        if (!tapePresent) return "No tape";
        if (playing) {
            playing = false;
            return "Stopped";
        }
        if (recording) {
            recording = false;
            return "Recording stopped";
        }
        return "Already stopped";
    }

    public String pressRec() {
        if (!tapePresent) return "No tape";
        if (recording) return "Already recording";
        if (playing) return "Stop playback before recording";
        recording = true;
        return "Recording started";
    }

    public String playRadio() {
        if (recording) return "Cannot play radio while recording";
        if (playing) {
            playing = false;
            return "Tape stopped, playing radio";
        }
        return "Playing radio";
    }

    public String getStatus() {
        if (!tapePresent) return "NO_TAPE";
        if (recording) return "RECORDING";
        if (playing) return "PLAYING";
        return "STOPPED";
    }
}
