package by.et.rgbcircle;

/**
 * The base class of the circles.
 * Date: 03/18/2016
 *
 * @author Andrei_Khadziukou
 */
public class SimpleCircle {

    protected int x;
    protected int y;
    protected int radius;
    private int color;

    public SimpleCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isIntersect(SimpleCircle circle) {
        return radius + circle.radius <= Math.sqrt(Math.pow(circle.x - x, 2) + Math.pow(circle.y - y, 2));
    }
}
