package ge.edu.ug.patterns.behavioral.iterator.dfs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// PROBLEM: both clients work, but each owns a private copy of the DFS loop.
// There is no way to hand them a different traversal (e.g. BFS) without rewriting both.
class VertexTest {

    /*
     *        A
     *      /   \
     *     B     C
     *    / \   / \
     *   D   E     F
     *       |
     *       A   (E -> A closes a cycle)
     */
    private Vertex<String> a;

    @BeforeEach
    void buildGraph() {
        a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");
        Vertex<String> e = new Vertex<>("E");
        Vertex<String> f = new Vertex<>("F");
        a.setNeighbours(List.of(b, c));
        b.setNeighbours(List.of(d, e));
        c.setNeighbours(List.of(e, f));
        e.setNeighbours(List.of(a));
    }

    @Test
    void printerVisitsInDepthFirstOrder() {
        assertEquals("A B D E C F", new GraphPrinter().print(a));
    }

    @Test
    void routeFinderUsesItsOwnCopyOfTheSameLoop() {
        RouteFinder finder = new RouteFinder();
        assertTrue(finder.canReach(a, "F"));
        assertFalse(finder.canReach(a, "Z"));
    }
}
