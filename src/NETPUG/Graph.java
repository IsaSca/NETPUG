package NETPUG;

import java.util.ArrayList;

/**
 * A collection of all vertices.
 * @author Isaac Scarisbrick
 * @version 0.1
 * @since 0.1
 */
public class Graph {
    /**
     * A list of all vertices in the graph.
     */
    ArrayList<Vertex> vertices;

    /**
     * Constructs the graph
     * @param vertices Implementation for the NETPUG.Graph Nodes
     */
    public Graph(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

    /**
     * Constructs an empty graph
     */
    public Graph(){
        this.vertices = new ArrayList<>();
    }

    /**
     * Gets the ArrayList of Vertices
     * @return Returns an ArrayList of Vertices.
     */
    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    /**
     * Sets the ArrayList to specific Vertices.
     * @param vertices The ArrayList to set the Vertices of the NETPUG.Graph to.
     */
    public void setVertices(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

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
         * This will determine whether the graph is or isn't Eulerian.
         */
        if (eulerNode == 2 || eulerNode == 0) {
            return true;
        }
        return false;
    }
    public boolean isNode(int n) {
        for (Vertex v: vertices) {
            if (n == v.getID()) {
                return true;
            }
        }
        return false;
    }
}
