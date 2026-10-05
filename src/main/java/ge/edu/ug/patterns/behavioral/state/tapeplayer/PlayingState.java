package ge.edu.ug.patterns.behavioral.state.tapeplayer;

// Concrete State
public class PlayingState extends TapePlayerState {

    public PlayingState(TapePlayer player) {
        super(player);
    }

    @Override
    public String eject() {
        return "Stop the tape before ejecting";
    }

    @Override
    public String pressPlay() {
        return "Already playing";
    }

    @Override
    public String pressStop() {
        player.setState(new StoppedState(player));
        return "Stopped";
    }

    @Override
    public String pressRec() {
        return "Stop playback before recording";
    }

    @Override
    public String playRadio() {
        player.setState(new StoppedState(player));
        return "Tape stopped, playing radio";
    }

    @Override
    public String name() {
        return "PLAYING";
    }
}
