package ge.edu.ug.patterns.structural.flyweight.storehouse;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {

    @Test
    public void testBoxCreation() {
        List<Box> boxes = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            boxes.add(StoreSimpleFactory.createBox("s"));
            boxes.add(StoreSimpleFactory.createBox("m"));
            if (i % 3 == 0) {
                boxes.add(StoreSimpleFactory.createBox("l"));
            }
            if (i % 2 == 0) {
                boxes.add(StoreSimpleFactory.createBox("s"));
            }
            if (i % 5 == 0) {
                boxes.add(StoreSimpleFactory.createBox("m-metal"));
            }
        }

        // only 4 kinds of box, but every one of the 304 boxes carries its own copy
        // of width, height, depth, material and color
        assertEquals(304, boxes.size());
        System.out.println("Total Box instances created: " + Box.getInstanceCount());
        System.out.println("Size/material/color copies stored: " + boxes.size());
    }

    @Test
    public void boxesOfSameSizeAreEqualButDuplicated() {
        Box first = StoreSimpleFactory.createBox("m-metal");
        Box second = StoreSimpleFactory.createBox("m-metal");

        assertEquals(first.getWidth(), second.getWidth());
        assertEquals("metal", second.getMaterial());
        assertEquals("silver", second.getColor());
        assertNotEquals(first.getId(), second.getId());
    }

    @Test
    public void unknownSizeThrows() {
        assertThrows(IllegalArgumentException.class, () -> StoreSimpleFactory.createBox("xl"));
    }
}
