import java.util.ArrayList;

/**
 * The implementation for each node.
 * @author Isaac Scarisbrick
 * @version 0.1
 * @since 0.1
 */
public class Vertex {
    private ArrayList<Vertex> connections = new ArrayList<>();
    private int ID;
    private int weight;

    /**
     * Adds a single vertex connection.
     *@param g A Vertex to be added to connections.
     *@since 0.1
     */
    public void addConnection(Vertex g) {
        connections.add(g);
    }

    /**
     * Adds a lot of vertices, hence the name.
     * @since 0.1
     * @param a The multiple vertices to be added to the connections.
     */
    public void addLots(ArrayList<Vertex> a) {
        connections.addAll(a);
    }

    /**
     * Finds a node based on given ID.
     * @param ID The ID of the vertex you want to find.
     * @return True for found, false for not.
     */
    public boolean findNode(int ID) {
        if (this.ID == ID) {
            return true;
        } else {
            for (Vertex g : connections) {
                g.findNode(ID);
            }
        }
        return false;
    }

    //BELOW HERE IS BORING SHIT

    public Vertex(ArrayList<Vertex> connections, int ID, int weight) {
        this.connections = connections;
        this.ID = ID;
        this.weight = weight;
    }
    public ArrayList<Vertex> getConnections() {
        return connections;
    }
    public void setConnections(ArrayList<Vertex> connections) {
        this.connections = connections;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}
