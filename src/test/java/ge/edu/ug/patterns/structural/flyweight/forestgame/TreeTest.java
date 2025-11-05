package ge.edu.ug.patterns.structural.flyweight.forestgame;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TreeTest {
    private final int FOREST_SIZE = 10000;
    private final int FOREST_WIDTH = 60;
    private final Random random = new Random(42);

    @Test
    public void testForestGame() {
        List<Tree> forest = new ArrayList<>();
        Tree tree;

        for (int row = 0; forest.size() < FOREST_SIZE; row++) {
            for (int col = 0; col < FOREST_WIDTH; col++) {
                if (forest.size() == FOREST_SIZE) {
                    break;
                }
                int treeType = random.nextInt(4);
                switch (treeType) {
                    case 0:
                        tree = new OakTree(row, col, random.nextInt(20));
                        forest.add(tree);
                        break;
                    case 1:
                    case 2:
                        tree = new PineTree(row, col, random.nextInt(30));
                        forest.add(tree);
                        break;
                    case 3:
                        // empty spot, no tree
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + treeType);
                }
            }
        }

        // 10,000 trees, but only as many distinct props objects as there are tree types
        Map<TreeCommonProps, Integer> treesPerProps = new IdentityHashMap<>();
        for (Tree t : forest) {
            treesPerProps.merge(t.getCommonProps(), 1, Integer::sum);
        }
        assertEquals(FOREST_SIZE, forest.size());
        assertEquals(2, treesPerProps.size());
        assertEquals(TreeCommonPropsFactory.flyweightCount(), treesPerProps.size());
        System.out.println("Trees: " + forest.size() + ", shared props objects: " + treesPerProps.size());
    }

    @Test
    public void treesOfSameTypeShareTheSamePropsInstance() {
        Tree oak1 = new OakTree(0, 0, 5);
        Tree oak2 = new OakTree(10, 20, 15);
        Tree pine = new PineTree(1, 1, 25);

        assertSame(oak1.getCommonProps(), oak2.getCommonProps());
        assertSame(TreeCommonPropsFactory.get("OakTree"), oak1.getCommonProps());
        assertEquals("Oak", oak1.getCommonProps().getSpecies());
        assertEquals("Pine", pine.getCommonProps().getSpecies());

        // extrinsic state stays per tree
        assertEquals(10, oak2.locationX);
        assertEquals(15, oak2.height);
    }

    @Test
    public void unknownTreeTypeThrows() {
        assertThrows(IllegalArgumentException.class, () -> TreeCommonPropsFactory.get("PalmTree"));
    }
}
