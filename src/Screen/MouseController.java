package Screen;

import Screen.Util.Vector;

public class MouseController {

    private boolean mouseDown;
    private Vector lastClick;


    public MouseController() {
        mouseDown = false;
        lastClick = new Vector(0, 0);
    }

    public Vector clickEvent(Vector clickPos) {
        if (!mouseDown) {
            mouseDown = true;
            lastClick = clickPos;
            return new Vector(0, 0);
        }
        mouseDown = false;
        return lastClick.getSub(clickPos);
    }

    public double scrollEvent(double val) {
        return 0.1 * val;
    }
}
