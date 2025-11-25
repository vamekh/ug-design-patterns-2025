package ge.edu.ug.patterns.behavioral.iterator.dfs;

import org.junit.jupiter.api.Test;

import java.util.List;

class VertexTest {
    @Test
    public void testGraphNode() {
        Vertex<String> nodeD = new Vertex<>("D");
        Vertex<String> nodeE = new Vertex<>("E");
        Vertex<String> nodeB = new Vertex<>("B");
        Vertex<String> nodeF = new Vertex<>("F");
        Vertex<String> nodeC = new Vertex<>("C");
        Vertex<String> nodeA = new Vertex<>("A");
        nodeB.setNeighbours(List.of(nodeD, nodeE));
        nodeA.setNeighbours(List.of(nodeB, nodeC));
        nodeC.setNeighbours(List.of(nodeF, nodeE));

        DfsIterator<String> dfs = new DfsIterator<>(nodeA);
        while (dfs.hasNext()) {
            String current =  dfs.next();
            System.out.println(current);
        }
    }


    /*
    *        A
    *      /   \
    *     B     C
    *    / \  /  \
    *   D   E     F
    * */
}
