package Screen;

import javafx.scene.layout.GridPane;

public class Controller extends GridPane {

    private double maxHeight;//Height of the screen
    private double maxWidth;//Width of the screen
    private int threads;//Number of threads allocated to processing

    /**
     * Constructor for the controller
     * @param height Height of the screen
     * @param width Width of the screen
     * @param threads Number of threads possible to use
     */

    public Controller(double height, double width, int threads){
        this.maxHeight = height;
        this.maxWidth = width;
        this.threads = threads;
        //runThread();
    }
}
