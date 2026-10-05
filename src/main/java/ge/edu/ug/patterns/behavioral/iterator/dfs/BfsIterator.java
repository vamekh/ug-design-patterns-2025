package ge.edu.ug.patterns.behavioral.iterator.dfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;

// Concrete Iterator: breadth-first. Clients switch to it without changing a line.
public class BfsIterator<T> implements Iterator<T> {
    private final Queue<Vertex<T>> queue = new ArrayDeque<>();
    private final Set<Vertex<T>> visited = new HashSet<>();

    public BfsIterator(Vertex<T> start) {
        queue.add(start);
        visited.add(start);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        Vertex<T> current = queue.poll();
        for (Vertex<T> neighbour : current.getNeighbours()) {
            if (visited.add(neighbour)) {
                queue.add(neighbour);
            }
        }
        return current.getValue();
    }
}
