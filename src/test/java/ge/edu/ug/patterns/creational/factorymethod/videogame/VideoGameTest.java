package ge.edu.ug.patterns.creational.factorymethod.videogame;

import org.junit.jupiter.api.Test;

public class VideoGameTest {
    @Test
    public void testVideoGame(){

        Level forestLevel = new Level("Forest");
        forestLevel.startLevel();

        Level volcanoLevel = new Level("Volcano");
        volcanoLevel.startLevel();

    }
}
