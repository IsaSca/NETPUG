package Screen;

import NETPUG.TestGraph;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application{

    //To get javafx 12 running: https://openjfx.io/openjfx-docs/#install-javafx
    //Next bit is in the above link, but if you didn't read it first time(Like me...), then it's written below as well.
    //Once installed you need to add this to the "VM options" section of the runtime configuration(The drop down at the top right next to the green play button):
    //--module-path "\path\to\javafx-sdk-12.0.1\lib" --add-modules javafx.controls,javafx.fxml

    //Things you'll want to customise
    private boolean FPS = false;//Shows FPS counter in console(Because why not?)
    private int THREADS = 8;//Number of threads to utilise for calculations(I recommend a health number of OVER 9000!)

    //Used for FPS counting(1 fps, 2fps, 4fps, 5fps wait... We missed one, uh oh problems....)
    private final long[] frameTimes = new long[100];
    private int frameTimeIndex = 0;
    private boolean arrayFilled = false;
    /**
    * Does the thing that makes the things happen. It's a psvm, it does what it's told....
    * Launches the stage
    * @param args The args from command line. The stuff that's always there...
     */
    public static void main(String[] args) {
        launch(args);//Starts the everything on the screen
    }

    /**
     * The setup of the stage and controllers
     * @param mainStage It just gets there, don't ask
     */
    public void start(Stage mainStage){
        //Says whether the graphics card can/is being used(Not sure if it really matters but It's nice to know about it)
        if (Platform.isSupported(ConditionalFeature.GRAPHICS)) {
            System.out.println("Graphics acceleration on.");
        }
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();//Gets the screen size(Means that people with small screens can still see the exit button...)
        double maxX = screenBounds.getMaxX() - screenBounds.getMinX();//Gets the width of the screen
        double maxY = screenBounds.getMaxY() - screenBounds.getMinY() + 2;//Gets the height of the screen

        //TestGraph test = new TestGraph();



        Controller cont = new Controller(maxY, maxX, THREADS);//Creates the controller, most things are done through this rather than the main class
        Scene scene = new Scene(cont);//Creates a Scene(Not the fainting lady one...), this is needed so that you can set that is showing in the screen
        mainStage.setScene(scene);
        //Sets the scene being shown on the mainStage(This is beginning to sound like I'm directing a pantomime, oh wait it's my code it may as well be one...)
        mainStage.setFullScreen(true);//Sets the stage to use fullscreen(The one that you have to press esc to getVertex out of, "You WILL look at what I want you to!")
        mainStage.setAlwaysOnTop(false);//Makes it so that you can tab out of it without unfocusing and stuff like that(It's just generally nicer)

        //An animation timer, this is essentially another thread linked to your screens fps.
        //I believe it stops its processes if it takes too long and starts another(This'll be the root of most of our problems...)
        AnimationTimer at = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Platform.runLater(() -> {//Sets this as a task to be run when the system has time(So you never know, this might not even work!)
                    if (FPS) {//I'm not even going to pretend I know all of what this does. It works that's all I know
                        long oldFrameTime = frameTimes[frameTimeIndex];//Gets the time of the last frame to be used in calculating the FPS
                        frameTimes[frameTimeIndex] = now;//Sets the current time to the time handed in to the timer
                        frameTimeIndex = (frameTimeIndex + 1) % frameTimes.length;//Moves to the next array position
                        if (frameTimeIndex == 0) {//When the array gets filled sets the boolean to true, this allows the FPS to be shown
                            arrayFilled = true;
                        }
                        if (arrayFilled) {//Calculates the fps only when it has a stock of values to use as the average
                            long elapsedNanos = now - oldFrameTime;
                            long elapsedNanosPerFrame = elapsedNanos / frameTimes.length;
                            double frameRate = 1_000_000_000.0 / elapsedNanosPerFrame;
                            System.out.print("\r" + String.format("Current frame rate: %.3f. ", frameRate));//Prints the current FPS to 3 digits(I think)
                        }
                    }
                });//I believe you can put any code you need to run either in the run later section or after, test it out!
                cont.draw();//Draws everything, EVERYTHING!
            }
        };

        mainStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {//Adds an clickEvent handler for keys(Like a groundsman or something)
                    switch (event.getCode()) {//A switch, because they're lightning fast! Or at least faster than an if else chain, and nicer looking
                        case E://EEEEEEEE
                            at.stop();//Stops teh animation timer(Kids, the shows over grow up and stop watching anime at teh cinema!)
                            mainStage.close();//Stops the stage
                            //Add any other required stops for different threads here(It's not nice losing control of your threads, they might sit in the corner making christmas jumpers or socks that don't fit you...)
                            System.exit(0);//Stops the program manually and 'should' stop all the threads
                            break;
                        case R:
                            break;
                    }
                }
        );
        mainStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);//Removes esc as the escape key for full screen
        at.start();//Starts the animation timer(WE GO!)
        mainStage.show();//Raises the curtains(Sets the mainStage to be shown, duh...)
    }
}
