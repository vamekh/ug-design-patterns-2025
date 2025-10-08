package ge.edu.ug.patterns.creational.factorymethod.videogame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class VideoGameTest {
    @Test
    public void testVideoGame(){

        Level forestLevel = new ForestLevel();
        assertInstanceOf(Dinosaur.class, forestLevel.startLevel());

        Level volcanoLevel = new VolcanoLevel();
        assertInstanceOf(Dragon.class, volcanoLevel.startLevel());

    }
}
