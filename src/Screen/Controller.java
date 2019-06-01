package Screen;

import NETPUG.Graph;
import NETPUG.Vertex;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
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
        this.maxHeight = height;//Sets the height of the screen
        this.maxWidth = width;//Sets the width of the screen
        this.threads = threads;//Sets the number of threads available for processing
        //runThread();
        generateGraph();//Generates a test graph
        disp = new Display(maxWidth, maxHeight);//Creates the display object
        disp.createTree(graph);//Creates a tree of all the vertexes in the graph by ID for searching and sorting
        this.add(disp,1,1);//Adds the display to the gridpane
    }

    /**
     * Method to generate a graph for testing
     * Might need to be changed, looks like it just links every one to every one...
     */
    public void generateGraph(){
        ArrayList<Vertex> vertexes = new ArrayList<>();//Creates an arraylist to store the vertexes
        for (int ID = 0; ID < 99; ID++) {//Loops for the specified number of times to create that many vertexes
            int weight = ThreadLocalRandom.current().nextInt((999-1) + 1) - 1;
            //Creates a random variable for the weight of the vertex
            vertexes.add(new Vertex(ID, weight));//Adds the new vertex to the arraylist
        }
        graph = new Graph(vertexes);//Creates a new graph with the inputted vertexes
        for (Vertex vertex1 : graph.getVertices()) {//Loops through all the vertexes
            if (vertex1.getConnections().size() == 0) {//If it has no connections
                for (Vertex vertex2 : graph.getVertices()) {//Loop through the vertexes
                    vertex1.addConnection(vertex2);//Add a connection
                }
            }
        }
    }

    /**
     * Method to call redraw methods of contained components
     *
     */
    public void draw(){
        disp.draw();//Calls the draw method of the display object
    }
}
