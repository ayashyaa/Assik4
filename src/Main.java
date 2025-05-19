public class Main {
    public static void main(String[] args) {
        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");

        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);

        graph.addEdge(a, b, 1.0);
        graph.addEdge(b, c, 2.0);
        graph.addEdge(a, d, 4.0);
        graph.addEdge(d, c, 1.0);

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, a);
        for (Vertex<String> v : bfs.getPath(c)) {
            System.out.print(v.getData() + " ");
        }

        System.out.println("\nDijkstra:");
        Search<String> dijkstra = new DijkstraSearch<>(graph, a);
        for (Vertex<String> v : dijkstra.getPath(c)) {
            System.out.print(v.getData() + " ");
        }
    }
}
