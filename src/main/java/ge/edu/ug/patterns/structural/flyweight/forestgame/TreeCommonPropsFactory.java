package ge.edu.ug.patterns.structural.flyweight.forestgame;

import java.util.Map;

// Flyweight factory: exactly one shared instance per tree type.
public class TreeCommonPropsFactory {
    private static final Map<String, TreeCommonProps> TREE_PROPS = Map.of(
            PineTree.class.getSimpleName(), new TreeCommonPropsImpl("brown", "Pine", "needles", "vertical"),
            OakTree.class.getSimpleName(), new TreeCommonPropsImpl("gray", "Oak", "broadleaf", "spreading")
    );

    public static TreeCommonProps get(String treeType) {
        TreeCommonProps props = TREE_PROPS.get(treeType);
        if (props == null) {
            throw new IllegalArgumentException("Unknown tree type: " + treeType);
        }
        return props;
    }

    public static int flyweightCount() {
        return TREE_PROPS.size();
    }
}
