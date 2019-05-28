package Screen;

import NETPUG.Graph;
import NETPUG.Vertex;
import Screen.Util.BTNode;
import Screen.Util.BTree;
import Screen.Util.Vector;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Display extends Canvas {

    private int RADIUS = 10;
    private double scale;

    private double width;
    private double height;

    private Vector shift;
    private MouseController mouseCont;

    private BTree nodes;
    private ArrayList<Vertex> vertexes;
    private ArrayList<BTNode> temp;

    public Display(double width, double height) {
        this.setWidth(width);
        this.width = width;
        this.setHeight(height);
        this.height = height;
        this.shift = new Vector(0, 0);
        this.mouseCont = new MouseController();
        this.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> shift.add(mouseCont.clickEvent(new Vector(event.getX(), event.getY()))));
        this.addEventHandler(ScrollEvent.SCROLL_FINISHED, event -> scale += mouseCont.scrollEvent(event.getDeltaY()));
    }

    public void createTree(Graph graph) {
        nodes = new BTree();
        for (Vertex v : graph.getVertices()) {
            nodes.add(v);
        }
        generatePositions(nodes.nodeInList());
    }

    public void generatePositions(ArrayList<BTNode> nodes) {
        for (BTNode node : nodes) {
            node.setPos(
                    new Vector(ThreadLocalRandom.current().nextDouble(4 * width) - 2 * width,
                            ThreadLocalRandom.current().nextDouble(4 * height) - 2 * height)
            );
        }
        this.temp = nodes;
    }

    public void draw() {
        GraphicsContext g = this.getGraphicsContext2D();
        Vector tempVec;
        for (BTNode node: temp){

        }
    }
}
