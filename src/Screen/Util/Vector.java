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

    public void mult(double mult) {
        this.x *= mult;
        this.y *= mult;
    }

    public Vector getMult(double mult) {
        return new Vector(this.x * mult, this.y * mult);
    }

    public void neg() {
        this.x = -x;
        this.y = -y;
    }

    public Vector getNeg() {
        return new Vector(-x, -y);
    }

    public Vector getCopy() {
        return new Vector(x, y);
    }

    public double length() {
        return Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
    }

    public double lengthTo(Vector other){
        return getSub(other).length();
    }

    public double angleTo(Vector other){
        Vector temp = getSub(other);
        return Math.atan2(temp.y(), temp.x());
    }

    /**
     *
     * @param angle Angle in radians
     * @param distance Distance to the point you want to get back from this one
     * @return The vector point of the point defined by the inputs
     */
    public Vector getPointAt(double angle, double distance) {
        double newX = Math.cos(angle) * distance;
        double newY = Math.sin(angle) * distance;
        return new Vector(this.x + newX, this.y + newY);
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
