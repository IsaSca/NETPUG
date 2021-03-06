package NETPUG;

import java.util.ArrayList;
import java.util.Scanner;

import Screen.Util.Vector;

/**
 * The implementation for each node.
 *
 * @author Isaac Scarisbrick
 * @version 0.1
 * @since 0.1
 */

public class Vertex {
    private ArrayList<Vertex> connections = new ArrayList<>();
    private int ID;
    private int weight;
    private Vector vector;

    public Vertex(int ID) {
        this.ID = ID;
    }

    public Vertex(int ID, int weight) {
        this.ID = ID;
        this.weight = weight;
    }

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

    public Vector getVector() {
        return vector;
    }

    public void setVector(Double x, Double y) {
        this.vector = new Vector(x, y);
    }

    public void setVector(Vector v) {
        /*for (Vertex con : connections) {
            for (Vertex conOther : con.getConnections()) {
                if (conOther.getID() == this.ID) {
                    conOther.setVector(v);
                }
            }
        }*/
        this.vector = v;
    }

    /**
     * Adds a single vertex connection.
     *
     * @param g A NETPUG.Vertex to be added to connections.
     * @since 0.1
     */
    public void addConnection(Vertex g) {
        connections.add(g);
    }

    /**
     * Adds a lot of vertices, hence the name.
     *
     * @param a The multiple vertices to be added to the connections.
     * @since 0.1
     */
    public void addLots(ArrayList<Vertex> a) {
        connections.addAll(a);
    }

    /**
     * Finds a node based on given ID.
     *
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

    //BELOW HERE IS BORING

    /**
     * Puts Connections into a String.
     *
     * @return Returns a String containing the connections.
     * @author Hawkeye
     */
    private String connectionsToString() {
        if (this.connections.size() > 0) {
            StringBuilder connectionsStr = new StringBuilder();
            int max = connections.size() - 1;
            for (int pos = 0; pos < max; pos++) {
                connectionsStr.append(connections.get(pos).getID()).append(", ");
            }
            connectionsStr.append(connections.get(max).getID());
            return connectionsStr.toString();
        }
        return "null";
    }

    /**
     * Puts a vertex into a string form.
     *
     * @return A string containing vertex information
     * @author IsaSca
     */
    @Override
    public String toString() {
        return "Vertex: " + ID + " {" +
                "connections=[" + connectionsToString() +
                "], ID=" + ID +
                ", weight=" + weight +
                '}';
    }

    /**
     * An implementation of toString that is used when connectionsToString isn't working.
     *
     * @return A basic vertex to string.
     * @author IsaSca
     */
    public String basicToString() {
        return "Vertex[" +
                "connections=[null]" +
                ", ID=" + ID +
                ", weight=" + weight +
                ']';
    }

    public boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }

    }

    public boolean checkVertex(Graph graph, Vertex vertex, String check) {
        if (isInt(check)) {
            if (graph.isNode(Integer.parseInt(check))) {
                vertex.addConnection(new Vertex(Integer.parseInt(check)));
                return true;
            } else {
                System.out.println("Not a node");
                return false;
            }
        } else {
            System.out.println("Not an integer");
            return false;
        }
    }


}