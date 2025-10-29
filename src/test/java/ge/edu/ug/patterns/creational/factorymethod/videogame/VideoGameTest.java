package ge.edu.ug.patterns.creational.factorymethod.videogame;

import org.junit.jupiter.api.Test;

public class VideoGameTest {
    @Test
    public void testVideoGame(){

        Level forestLevel = new Level1();
        forestLevel.startLevel();

        Level volcanoLevel = new Level2();
        volcanoLevel.startLevel();

    }
}
