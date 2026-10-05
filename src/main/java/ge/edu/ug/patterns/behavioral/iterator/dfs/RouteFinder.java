package ge.edu.ug.patterns.behavioral.iterator.dfs;

// Client: same traversal, no copied loop.
public class RouteFinder {

    public <T> boolean canReach(Iterable<T> traversal, T target) {
        for (T value : traversal) {
            if (value.equals(target)) return true;
        }
        return false;
    }
}
