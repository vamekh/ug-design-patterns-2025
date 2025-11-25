package ge.edu.ug.patterns.behavioral.iterator.dfs;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DfsIterator <T> implements Iterator<T> {
    private final Vertex<T> initialVertex;
    private final Set<Vertex<T>> visitedNodes = new HashSet<>();
    private Deque<Vertex<T>> stack = new LinkedList<>();
    private Vertex<T> currentNode;

    public DfsIterator(Vertex<T> initialVertex) {
        this.initialVertex = initialVertex;
        stack.add(initialVertex);
    }

    @Override
    public void reset() {
        stack.clear();
        visitedNodes.clear();
        stack.push(initialVertex);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        if (stack.isEmpty()) return null;
        currentNode = stack.pop();
        if(visitedNodes.contains(currentNode)) return next();
        if(currentNode.neighbours != null){
            currentNode.neighbours.stream()
                    .filter(n -> !visitedNodes.contains(n))
                    .forEach(n -> stack.push(n));
        }
        visitedNodes.add(currentNode);
        return currentNode.value;
    }
}
