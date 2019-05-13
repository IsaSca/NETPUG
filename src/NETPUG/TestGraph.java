package NETPUG;

import java.util.ArrayList;
import java.util.Random;

public class TestGraph {
    public static void main(String[] args) {
        ArrayList<Vertex> v = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 999; i++) {
            int q = r.nextInt((999999-1) + 1) - 1;
            v.add(new Vertex(q, i));
        }
        Graph g = new Graph(v);
        for (Vertex vertex : g.vertices) {
            if (vertex.getConnections().size() == 0) {
                for (Vertex q : g.vertices) {
                    vertex.addConnection(q);
                }
            }
        }
        for (Vertex p : g.vertices) {

            System.out.println(p.toString());
        }

    }
}
