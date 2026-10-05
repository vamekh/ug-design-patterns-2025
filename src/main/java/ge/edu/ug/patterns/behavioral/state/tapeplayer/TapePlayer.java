package ge.edu.ug.patterns.behavioral.state.tapeplayer;

// Context: one state object instead of three booleans; every button is delegated.
public class TapePlayer {
    private TapePlayerState state = new NoTapeState(this);

    public String insertTape() {
        return state.insertTape();
    }

    public String eject() {
        return state.eject();
    }

    public String pressPlay() {
        return state.pressPlay();
    }

    public String pressStop() {
        return state.pressStop();
    }

    public String pressRec() {
        return state.pressRec();
    }

    public String playRadio() {
        return state.playRadio();
    }

    public String getStatus() {
        return state.name();
    }

    void setState(TapePlayerState state) {
        this.state = state;
    }
}
