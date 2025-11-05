package ge.edu.ug.patterns.structural.flyweight.forestgame;

import java.util.Map;

public class TreeCommonPropsFactory {
    private static final Map<String, TreeComonProps> TREE_PROPS = Map.of(
            PineTree.class.getSimpleName(), new TreeComonPropsImpl("brown", "Pine", "needles", "vertical"),
            OakTree.class.getSimpleName(), new TreeComonPropsImpl("gray", "Oak", "broadleaf", "spreading")
    );

    public static TreeComonProps get(String treeType) {
        return TREE_PROPS.get(treeType);
    }
}
