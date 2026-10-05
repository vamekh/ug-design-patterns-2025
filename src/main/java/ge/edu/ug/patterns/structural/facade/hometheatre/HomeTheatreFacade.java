package ge.edu.ug.patterns.structural.facade.hometheatre;

// Facade: one simple entry point over the four subsystem classes
public class HomeTheatreFacade {
    private static final int BANNER_WIDTH = 28;

    private final Projector projector;
    private final RollupScreen rollupScreen;
    private final DvdPlayer dvdPlayer;
    private final SoundSystem soundSystem;

    public HomeTheatreFacade(Projector projector, RollupScreen rollupScreen, DvdPlayer dvdPlayer, SoundSystem soundSystem) {
        this.projector = projector;
        this.rollupScreen = rollupScreen;
        this.dvdPlayer = dvdPlayer;
        this.soundSystem = soundSystem;
    }

    public void beginFilmSession(String film) {
        System.out.println("FilmSession begin");
        rollupScreen.rollDown();
        projector.on();
        soundSystem.on();
        soundSystem.setVolume(50);
        dvdPlayer.on();
        projector.setInput("DVD");
        dvdPlayer.play(film);
        printBanner(film);
    }

    public void endFilmSession() {
        System.out.println("FilmSession end");
        dvdPlayer.off();
        soundSystem.off();
        projector.off();
        rollupScreen.rollUp();
    }

    private void printBanner(String film) {
        String title = film.length() > BANNER_WIDTH ? film.substring(0, BANNER_WIDTH - 3) + "..." : film;
        int left = (BANNER_WIDTH - title.length()) / 2;
        int right = BANNER_WIDTH - title.length() - left;
        System.out.println("       ____________________________");
        System.out.println("      |                            |");
        System.out.println("      |" + " ".repeat(left) + title + " ".repeat(right) + "|");
        System.out.println("      |                            |");
        System.out.println("      |____________________________|");
    }
}
