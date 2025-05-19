import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private Map<Vertex<V>, Double> distances = new HashMap<>();
    private Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();
    private final Vertex<V> start;

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> start) {
        this.start = start;

        for (Vertex<V> v : graph.getVertices()) {
            distances.put(v, Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0);

        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        pq.add(start);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();
            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();
                double newDist = distances.get(current) + weight;

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }
    }

    @Override
    public List<Vertex<V>> getPath(Vertex<V> end) {
        LinkedList<Vertex<V>> path = new LinkedList<>();
        if (!distances.containsKey(end) || distances.get(end) == Double.POSITIVE_INFINITY) {
            return path;
        }

        for (Vertex<V> at = end; at != null; at = edgeTo.get(at)) {
            path.addFirst(at);
        }
        return path;
    }
}
