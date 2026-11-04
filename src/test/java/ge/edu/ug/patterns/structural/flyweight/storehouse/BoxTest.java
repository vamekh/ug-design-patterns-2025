package ge.edu.ug.patterns.structural.flyweight.storehouse;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {

    @Test
    public void testBoxCreation() {
        BoxCommonProps s = StoreSimpleFactory.getBox("s");
        BoxCommonProps m = StoreSimpleFactory.getBox("m");
        BoxCommonProps l = StoreSimpleFactory.getBox("l");
        BoxCommonProps mMetal = StoreSimpleFactory.getBox("m-metal");

        List<Box> boxes = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            boxes.add(new Box(s));
            boxes.add(new Box(m));
            if (i % 3 == 0) {
                boxes.add(new Box(l));
            }
            if (i % 2 == 0) {
                boxes.add(new Box(s));
            }
            if (i % 5 == 0) {
                boxes.add(new Box(mMetal));
            }
        }

        // 304 boxes, but only the 4 props objects the factory created up front
        Set<BoxCommonProps> distinctProps = Collections.newSetFromMap(new IdentityHashMap<>());
        for (Box box : boxes) {
            distinctProps.add(box.getCommonProps());
        }
        assertEquals(304, boxes.size());
        assertEquals(4, distinctProps.size());
        assertEquals(4, BoxCommonProps.getInstanceCount());

        System.out.println("Total BoxCommonProps instances created: " + BoxCommonProps.getInstanceCount());
        System.out.println("Total Box instances created: " + Box.getInstanceCount());
    }

    @Test
    public void boxesOfSameSizeShareTheSamePropsInstance() {
        Box first = new Box(StoreSimpleFactory.getBox("m-metal"));
        Box second = new Box(StoreSimpleFactory.getBox("m-metal"));

        assertSame(first.getCommonProps(), second.getCommonProps());
        assertEquals("metal", second.getCommonProps().getMaterial());
        assertEquals("silver", second.getColor());

        // the id is extrinsic state and stays per box
        assertNotEquals(first.getId(), second.getId());
    }

    @Test
    public void unknownSizeReturnsNull() {
        assertNull(StoreSimpleFactory.getBox("xl"));
    }
}
