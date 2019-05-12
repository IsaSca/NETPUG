import java.util.ArrayList;

/**
 * A collection of all vertices.
 * @version 0.1
 * @since 0.1
 */
public class Graph {
    /**
     * A list of all vertices in the graph.
     */
    ArrayList<Vertex> vertices = new ArrayList<>();

    /**
     * A method for determining whether a graph is Eulerian, and therefore efficient.
     * @return True for eulerian, false otherwise.
     */
    public boolean isEulerian() {
        /**
         * A counter for amount of odd vertices.
         */
        int eulerNode = 0;
        /**
         * Checks each vertex in the vertices.
         */
        for (Vertex vertex : vertices) {
            if (vertex.getConnections().size() % 2 != 0) {
                eulerNode += 1;
            }
        }
        /**
         * This will determine whether the graph is or isn't eulerian.
         */
        if (eulerNode == 2 || eulerNode == 0) {
            return true;
        }
        return false;
    }
}
