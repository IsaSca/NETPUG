import java.util.ArrayList;

public class Graph {
    ArrayList<GraphNode> vertices = new ArrayList<>();
    public boolean isEulerian() {
        int eulerNode = 0;
        for (GraphNode g : vertices) {
            if (g.getConnections().size() % 2 != 0) {
                eulerNode += 1;
            }
        }
        if (eulerNode > 2) {
            return true;
        }
        return false;
    }
}
