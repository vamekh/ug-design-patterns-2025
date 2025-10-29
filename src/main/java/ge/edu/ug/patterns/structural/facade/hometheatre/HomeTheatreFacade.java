package ge.edu.ug.patterns.structural.facade.hometheatre;

public class HomeTheatreFacade {
    private Projector projector;
    private RollupScreen rollupScreen;
    private DvdPlayer dvdPlayer;
    private SoundSystem soundSystem;

    public HomeTheatreFacade(Projector projector, RollupScreen rollupScreen, DvdPlayer dvdPlayer, SoundSystem soundSystem) {
        this.projector = projector;
        this.rollupScreen = rollupScreen;
        this.dvdPlayer = dvdPlayer;
        this.soundSystem = soundSystem;
    }

    public void beginFilmSession(String film){
        System.out.println("FilmSession begin");
        rollupScreen.rollDown();
        projector.on();
        soundSystem.on();
        soundSystem.setVolume(50);
        dvdPlayer.on();
        projector.setInput("DVD");
        dvdPlayer.play(film);

        String blank = "              ".substring(0,14-film.length()/2);
        System.out.println("       ____________________________");
        System.out.println("      |                            |");
        System.out.println("      |" + blank + film + blank + "|");
        System.out.println("      |                            |");
        System.out.println("      |____________________________|");
    }

    public void endFilmSession(){
        System.out.println("FilmSession end");
        dvdPlayer.off();
        soundSystem.off();
        projector.off();
        rollupScreen.rollUp();
    }
}
