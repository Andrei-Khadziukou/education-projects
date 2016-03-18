package by.et.rgbcircle;

/**
 * The player in our game.
 * Date: 03/18/2016
 *
 * @author Andrei_Khadziukou
 */
public class MainCircle {

    public static final int INITIAL_RADIUS = 10;
    private int x;
    private int y;
    private int radius;

    public MainCircle(int x, int y) {
        this.x = x;
        this.y = y;
        this.radius = INITIAL_RADIUS;
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
}
