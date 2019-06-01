package Screen;

import Screen.Util.Vector;

public class MouseController {

    private Vector lastClick;//The last clicked position, used to calculate the shift for dragging the screen

    /**
     * Constructor, just sets a value for the last click to prevent any null pointers
     */
    public MouseController() {
        lastClick = new Vector(0, 0);//Sets the last click position to (0, 0)
    }

    /**
     * Called when the mouse is clicked to set the last clicked position. Prevents a jump when you click fora second time.
     * @param clickPos The position that the click happened.
     */
    public void mouseClicked(Vector clickPos){
        lastClick = clickPos;//Sets the last click position
    }

    /**
     * Called every time the mouse is dragged.
     * @param clickPos Where the event triggered
     * @param scale The current zoom scale, changes how far the screen is shifted
     * @return The shift that the screen will move
     */
    public Vector clickEvent(Vector clickPos, double scale) {
        Vector temp = lastClick.getSub(clickPos).getNeg().getMult(Math.pow(1, scale));
        //Quite a lot in this one. So the shift of the mouse is subtracted from the last position.
        //The shift is then negated so that it moves the same way as the mouse.
        //Lastly the result is multiplied 0.5^(the scale). This is to scale the shift with the zoom.
        lastClick = clickPos;//Store the current position as the last click
        return temp;//Return the calculated vector
    }

    /**
     * Called when the mouse is scrolled
     * @param val The amount that the mouse is scrolled.
     * @return The value that is to be added to the scale.
     */
    public double scrollEvent(double val) {
        return 0.25 * Math.signum(val);//Return the amount to be added to the scale, multiplied down so that it is not too much.
    }
}
