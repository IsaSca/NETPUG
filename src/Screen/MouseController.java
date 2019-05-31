package Screen;

import Screen.Util.Vector;

public class MouseController {

    private Vector lastClick;


    public MouseController() {
        lastClick = new Vector(0, 0);
    }

    public void mouseClicked(Vector clickPos){
        lastClick = clickPos;
    }

    public Vector clickEvent(Vector clickPos, double scale) {
        Vector temp = lastClick.getSub(clickPos).getNeg().getMult(scale*(1/scale));
        lastClick = clickPos;
        return temp;
    }

    public double scrollEvent(double val) {
        return 0.01 * val;
    }
}
