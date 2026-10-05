package ge.edu.ug.patterns.behavioral.state.tapeplayer;

// Concrete State
public class StoppedState extends TapePlayerState {

    public StoppedState(TapePlayer player) {
        super(player);
    }

    @Override
    public String eject() {
        player.setState(new NoTapeState(player));
        return "Tape ejected";
    }

    @Override
    public String pressPlay() {
        player.setState(new PlayingState(player));
        return "Playing from tape";
    }

    @Override
    public String pressStop() {
        return "Already stopped";
    }

    @Override
    public String pressRec() {
        player.setState(new RecordingState(player));
        return "Recording started";
    }

    @Override
    public String name() {
        return "STOPPED";
    }
}
