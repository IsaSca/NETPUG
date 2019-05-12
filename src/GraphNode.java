import java.util.ArrayList;

public class GraphNode {
    private ArrayList<GraphNode> connections = new ArrayList<>();
    private int ID;
    private int cost;

    public void addConnection(GraphNode g) {
        connections.add(g);

    }

    public void addLots(ArrayList<GraphNode> a) {
        connections.addAll(a);
    }

    public boolean findNode(int ID) {
        if (this.ID == ID) {
            return true;
        } else {
            for (GraphNode g : connections) {
                g.findNode(ID);
            }
        }
        return false;
    }






    //BELOW HERE IS BORING SHIT

    public GraphNode(ArrayList<GraphNode> connections, int ID, int cost) {
        this.connections = connections;
        this.ID = ID;
        this.cost = cost;
    }

    public ArrayList<GraphNode> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<GraphNode> connections) {
        this.connections = connections;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
