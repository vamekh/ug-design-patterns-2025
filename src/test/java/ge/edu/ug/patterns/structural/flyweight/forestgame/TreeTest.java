package ge.edu.ug.patterns.structural.flyweight.forestgame;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class TreeTest {
    private final int FOREST_SIZE = 10000;
    private final int FOREST_WIDTH = 60;
    private final Random random = new Random();

    @Test
    public void testForestGame() {
        List<Tree> forest = new ArrayList<>();
        StringBuilder sb;
        Tree tree;

        for (int row = 0; forest.size() < FOREST_SIZE; row++) {
            sb = new StringBuilder();
            for (int col = 0; col < FOREST_WIDTH; col++) {
                if (forest.size() == FOREST_SIZE) {
                    break;
                }
                int treeType = random.nextInt(4);
                switch (treeType) {
                    case 0:
                        tree = new OakTree(row, col, random.nextInt(20));
                        forest.add(tree);
                        sb.append(tree);
                        break;
                    case 1:
                    case 2:
                        tree = new PineTree(row, col, random.nextInt(30));
                        forest.add(tree);
                        sb.append(tree);
                        break;
                    case 3:
                        sb.append("🌱");
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + treeType);
                }
            }
            System.out.println(sb);
        }
    }

}
