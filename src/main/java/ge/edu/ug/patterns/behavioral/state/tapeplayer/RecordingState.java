package ge.edu.ug.patterns.behavioral.state.tapeplayer;

// Concrete State
public class RecordingState extends TapePlayerState {

    public RecordingState(TapePlayer player) {
        super(player);
    }

    @Override
    public String eject() {
        return "Stop recording before ejecting";
    }

    @Override
    public String pressPlay() {
        return "Recording in progress";
    }

    @Override
    public String pressStop() {
        player.setState(new StoppedState(player));
        return "Recording stopped";
    }

    @Override
    public String pressRec() {
        return "Already recording";
    }

    @Override
    public String playRadio() {
        return "Cannot play radio while recording";
    }

    @Override
    public String name() {
        return "RECORDING";
    }
}
