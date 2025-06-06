import java.util.HashSet;
import java.util.Set;

public class WeightedGraph<V> {
    private Set<Vertex<V>> vertices = new HashSet<>();

    public void addVertex(Vertex<V> vertex) {
        vertices.add(vertex);
    }

    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        source.addAdjacentVertex(dest, weight);
        dest.addAdjacentVertex(source, weight); // если граф ориентированный — убери эту строку
    }

    public Set<Vertex<V>> getVertices() {
        return vertices;
    }
}
