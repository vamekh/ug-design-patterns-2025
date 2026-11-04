package ge.edu.ug.patterns.structural.flyweight.storehouse;

import java.util.HashMap;
import java.util.Map;

public class StoreSimpleFactory {
    private static Map<String, BoxCommonProps> boxCache = new HashMap<>();

    static {
        boxCache.put("s", new BoxCommonProps(10, 10, 10, "cardboard", "brown"));
        boxCache.put("m", new BoxCommonProps(20, 20, 20, "cardboard", "brown"));
        boxCache.put("m-metal", new BoxCommonProps(20, 20, 20, "metal", "silver"));
        boxCache.put("l", new BoxCommonProps(30, 30, 30, "cardboard", "brown"));
    }

    public static BoxCommonProps getBox(String size) {
        return boxCache.get(size);
    }
}
