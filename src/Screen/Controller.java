package Screen;

import NETPUG.Graph;
import NETPUG.Vertex;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Controller extends GridPane {

    private double maxHeight;//Height of the screen
    private double maxWidth;//Width of the screen
    private int threads;//Number of threads allocated to processing

    private Display disp;//The canvas on which the graph is drawn

    private Graph graph;

    /**
     * Constructor for the controller
     *
     * @param height  Height of the screen
     * @param width   Width of the screen
     * @param threads Number of threads possible to use
     */

    public Controller(double height, double width, int threads) {
        this.maxHeight = height;
        this.maxWidth = width;
        this.threads = threads;
        //runThread();
        generateGraph();
        disp = new Display(maxWidth, maxHeight);
        disp.createTree(graph);
        this.add(disp,1,1);
    }
    /**
     * Method to generate a graph for testing
     *
     */
    public void generateGraph(){
        ArrayList<Vertex> vertexes = new ArrayList<>();
        for (int ID = 0; ID < 99; ID++) {
            int weight = ThreadLocalRandom.current().nextInt((999-1) + 1) - 1;
            vertexes.add(new Vertex(ID, weight));
        }
        graph = new Graph(vertexes);
        for (Vertex vertex1 : graph.getVertices()) {
            if (vertex1.getConnections().size() == 0) {
                for (Vertex vertex2 : graph.getVertices()) {
                    vertex1.addConnection(vertex2);
                }
            }
        }
    }

    /**
     * Method to call redraw methods of contained components
     *
     */
    public void draw(){
        disp.draw();
    }
}
