package ge.edu.ug.patterns.behavioral.state.tapeplayer;

// State: defaults shared by the "tape is inside" states; concrete states override what differs.
public abstract class TapePlayerState {
    protected final TapePlayer player;

    protected TapePlayerState(TapePlayer player) {
        this.player = player;
    }

    public String insertTape() {
        return "Tape already inserted";
    }

    public abstract String eject();

    public abstract String pressPlay();

    public abstract String pressStop();

    public abstract String pressRec();

    public String playRadio() {
        return "Playing radio";
    }

    public abstract String name();
}
