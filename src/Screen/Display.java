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
import javafx.scene.paint.Color;

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
        this.scale = 1;
        this.mouseCont = new MouseController();
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> mouseCont.mouseClicked(new Vector(event.getX(), event.getY())));
        this.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> shift.add(mouseCont.clickEvent(new Vector(event.getX(), event.getY()), scale)));
        this.addEventHandler(ScrollEvent.SCROLL, event -> {
            scale += mouseCont.scrollEvent(event.getDeltaY());
            if (scale < 0) {
                scale = 0;
            }
        });
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
        g.clearRect(0, 0, width, height);
        g.setFill(new Color(1, 0, 0, 1));
        Vector tempVec, midScreenShift = new Vector(width / 2, height / 2);
        for (BTNode node : temp) {
            tempVec = node.getPos().getAdd(shift).getMult(scale).getAdd(midScreenShift);
            g.fillOval(tempVec.x() - (RADIUS * scale) / 2, tempVec.y() - (RADIUS * scale) / 2, RADIUS * scale, RADIUS * scale);
            for (Vertex con : node.getData().getConnections()) {
                Vector otherPos = con.getVector().getAdd(shift).getMult(scale).getAdd(midScreenShift);
                drawEdge(g, tempVec, otherPos);
            }
        }
    }

    public void drawEdge(GraphicsContext g, Vector orig, Vector goTo) {
        double angle = orig.angleTo(goTo);
        Vector edgeFurther = goTo.getPointAt(angle, (RADIUS * scale) / 2);
        angle += Math.PI;
        angle %= 2 * Math.PI;
        Vector edgeClosest = orig.getPointAt(angle, (RADIUS * scale) / 2);
        g.strokeLine(edgeClosest.x(), edgeClosest.y(), edgeFurther.x(), edgeFurther.y());
        //Point line = realPos.getPointAt(this.angle, this.MAGIC_SIZE / 2.0);
        //g.strokeLine(realPos.getX() + this.MAGIC_SIZE / 2.0, realPos.getY() + this.MAGIC_SIZE / 2.0, line.getX() + this.MAGIC_SIZE / 2.0, line.getY() + this.MAGIC_SIZE / 2.0);
    }
}
