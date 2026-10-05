package ge.edu.ug.patterns.behavioral.iterator.dfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

// Concrete Iterator: depth-first, neighbours visited left to right.
public class DfsIterator<T> implements Iterator<T> {
    private final Deque<Vertex<T>> stack = new ArrayDeque<>();
    private final Set<Vertex<T>> visited = new HashSet<>();

    public DfsIterator(Vertex<T> start) {
        stack.push(start);
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && visited.contains(stack.peek())) {
            stack.pop();
        }
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        Vertex<T> current = stack.pop();
        visited.add(current);
        List<Vertex<T>> neighbours = current.getNeighbours();
        for (int i = neighbours.size() - 1; i >= 0; i--) {
            stack.push(neighbours.get(i));
        }
        return current.getValue();
    }
}
