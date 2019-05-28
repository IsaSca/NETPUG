package NETPUG;

import java.util.ArrayList;
import java.util.Random;
import Screen.Controller;

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
    private double x;
    private double y;

    /**
     * Adds a single vertex connection.
     *@param g A NETPUG.Vertex to be added to connections.
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

    /**
     * Puts Connections into a String.
     * @author Hawkeye
     * @return Returns a String containing the connections.
     */
    private String connectionsToString(){
        StringBuilder connectionsStr = new StringBuilder();
        int max = connections.size() - 1;
        for(int pos = 0; pos < max; pos++){
            connectionsStr.append(connections.get(pos).getID()).append(", ");
        }
        connectionsStr.append(connections.get(max).getID());
        return connectionsStr.toString();
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "connections=[" + connectionsToString() +
                "], ID=" + ID +
                ", weight=" + weight +
                '}';
    }

    public String basicToString() {
        return "Vertex[" +
                "connections=[null]" +
                ", ID=" + ID +
                ", weight=" + weight +
                ']';
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

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}