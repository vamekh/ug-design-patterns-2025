package ge.edu.ug.patterns.behavioral.state.tapeplayer;

// Concrete State
public class NoTapeState extends TapePlayerState {

    public NoTapeState(TapePlayer player) {
        super(player);
    }

    @Override
    public String insertTape() {
        player.setState(new StoppedState(player));
        return "Tape inserted";
    }

    @Override
    public String eject() {
        return "No tape to eject";
    }

    @Override
    public String pressPlay() {
        return "No tape";
    }

    @Override
    public String pressStop() {
        return "No tape";
    }

    @Override
    public String pressRec() {
        return "No tape";
    }

    @Override
    public String name() {
        return "NO_TAPE";
    }
}
