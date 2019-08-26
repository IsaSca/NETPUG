package NETPUG;

import java.util.Scanner;

public class TestGraph {

    public static void main(String[] args) {
        TestGraph tg = new TestGraph();
        Graph graph = tg.generateGraph();
        tg.printGraph(graph);
    }

    public TestGraph() {
    }

    /**
     * Allows generation of a graph
     */
    public Graph generateGraph() {
        Graph graph = new Graph();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to add some nodes?");
        if (scanner.next().toLowerCase().equals("yes")) {
            addNodes(graph);
            System.out.println("Would you like to add connections for each node?");
            if (scanner.next().toLowerCase().equals("yes")) {
                addVertexes(graph);
            }
            scanner.close();
        }
        return graph;
    }

    /**
     * Adds nodes to the specified Vertex
     */
    public void addNodes(Graph graph) {
        System.out.println("How many nodes do you want to add");
        Scanner scan = new Scanner(System.in);
        int amount = scan.nextInt();
        if (amount > 0) {
            System.out.println("Please enter your node(s)");
            for (int i = 0; i < amount; i++) {
                graph.vertices.add(new Vertex(scan.nextInt(), i));
            }
        }
    }

    /**
     * Adds vertexes to all the nodes
     */
    public void addVertexes(Graph graph) {
        for (Vertex v : graph.vertices) {
            addToVertex(v, graph);
        }
    }

    /**
     * Adds vertexes to all the inputted node?
     */
    public void addToVertex(Vertex v, Graph graph) {
        System.out.println("Please enter the connections for " + v.getID() + ". Type null when done.");
        Scanner scan = new Scanner(System.in);
        String check;
        while (!(check = scan.nextLine()).toLowerCase().equals("null")) {//Nifty thing I learnt last year
            if (isInt(check)) {
                int val = Integer.parseInt(check);//Just to reduce the checks
                if (graph.isNode(val)) {
                    v.addConnection(graph.getVertexByID(val));
                } else {
                    System.out.println("Not a node");
                }
            } else {
                System.out.println("Not an integer");
            }
        }
    }

    /**
     * Prints the inputted graph
     */
    public void printGraph(Graph graph) {
        for (Vertex v : graph.vertices) {
//            if(v.getConnections().size() == 0) {
//                System.out.println(v.toString());
//            } else {
//                System.out.println(v.basicToString());
//            }
            System.out.println(v.toString());
        }
    }

    public boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }

    }
}
