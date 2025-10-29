package ge.edu.ug.patterns.structural.facade.hometheatre;

import org.junit.jupiter.api.Test;

class HomeTheatreTest {
    @Test
    void test() {
        HomeTheatreFacade homeTheatre = new HomeTheatreFacade(
                new Projector(),
                new RollupScreen(),
                new DvdPlayer(),
                new SoundSystem()
        );

        homeTheatre.beginFilmSession("Mulholland Dr.");

        homeTheatre.endFilmSession();

    }

}
