package NETPUG;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
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

        } else {
            System.out.println("Thank you");
            System.exit(0);
        }
        for (Vertex v : graph.vertices) {
            System.out.println(v.basicToString());
        }


    }
}
