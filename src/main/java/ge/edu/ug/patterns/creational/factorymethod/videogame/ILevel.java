package ge.edu.ug.patterns.creational.factorymethod.videogame;

public interface ILevel {
    // Tightly coupled creation logic
      Enemy createEnemy();
      Obstacle createObstacle();
}
