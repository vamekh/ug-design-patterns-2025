package ge.edu.ug.patterns.behavioral.iterator.dfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

// Same DFS loop as GraphPrinter, copied and pasted.
public class RouteFinder {

    public <T> boolean canReach(Vertex<T> start, T target) {
        Deque<Vertex<T>> stack = new ArrayDeque<>();
        Set<Vertex<T>> visited = new HashSet<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            Vertex<T> current = stack.pop();
            if (visited.contains(current)) continue;
            visited.add(current);
            if (current.value.equals(target)) return true;
            for (int i = current.neighbours.size() - 1; i >= 0; i--) {
                stack.push(current.neighbours.get(i));
            }
        }
        return false;
    }
}
