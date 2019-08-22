package NETPUG;


import java.util.ArrayList;
import java.util.Scanner;

public class TestGraph {
    ArrayList<Vertex> vertices;
    Graph graph;
    public static void main(String[] args) {
        new TestGraph();
    }

    public TestGraph(){
        vertices = new ArrayList<>();
        graph = new Graph(vertices);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to add some nodes?");
        if (scanner.next().toLowerCase().equals("yes")) {
            System.out.println("How many nodes do you want to add");
            int amount = scanner.nextInt();
            if (amount > 0) {
                System.out.println("Please enter your node(s)");
                for (int i = 0; i < amount; i++) {
                    graph.vertices.add(new Vertex(scanner.nextInt(), i));
                }
            }
            System.out.println("Would you like to add connections for each node?");
            if (scanner.next().toLowerCase().equals("yes")) {
                for (Vertex v : graph.vertices) {
                    System.out.println("Please enter the connections for " + v.getID() + ". Type null when done.");
                    while (true) {
                        String check = scanner.nextLine();
                        if (isInt(check)) {
                            if (graph.isNode(Integer.parseInt(check))) {
                                v.addConnection(new Vertex(Integer.parseInt(check)));
                            }
                        } else if (check.equals("null")) {
                            break;
                        }

                    }
                }
            }

        } else {
            System.out.println("Thank you");
            System.exit(0);
        }
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
