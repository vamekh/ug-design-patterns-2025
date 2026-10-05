package ge.edu.ug.patterns.behavioral.iterator.dfs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    private Iterable<String> dfs;
    private Iterable<String> bfs;

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
        // Each for-loop asks for a fresh iterator, so traversals can be repeated.
        dfs = () -> new DfsIterator<>(a);
        bfs = () -> new BfsIterator<>(a);
    }

    @Test
    void printerVisitsInDepthFirstOrder() {
        assertEquals("A B D E C F", new GraphPrinter().print(dfs));
    }

    @Test
    void routeFinderReusesTheSameIterator() {
        RouteFinder finder = new RouteFinder();
        assertTrue(finder.canReach(dfs, "F"));
        assertFalse(finder.canReach(dfs, "Z"));
    }

    @Test
    void swappingToBreadthFirstNeedsNoClientChange() {
        assertEquals("A B C D E F", new GraphPrinter().print(bfs));
        assertTrue(new RouteFinder().canReach(bfs, "E"));
    }

    @Test
    void iteratorFollowsJavaContract() {
        Iterator<String> it = new DfsIterator<>(new Vertex<>("X"));
        assertTrue(it.hasNext());
        assertEquals("X", it.next());
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }
}
