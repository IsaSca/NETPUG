package Screen.Util;

public class Vector {

    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void add(Vector other) {
        x += other.x();
        y += other.y();
    }

    public Vector getAdd(Vector other) {
        return new Vector(x + other.x(), y + other.y());
    }

    public void sub(Vector other) {
        x -= other.x();
        y -= other.y();
    }

    public Vector getSub(Vector other) {
        return new Vector(x - other.x(), y - other.y());
    }

    public double x() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double y() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
