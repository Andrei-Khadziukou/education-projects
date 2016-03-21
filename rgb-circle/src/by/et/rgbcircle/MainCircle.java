package by.et.rgbcircle;

import android.graphics.Color;

/**
 * The player in our game.
 * Date: 03/18/2016
 *
 * @author Andrei_Khadziukou
 */
public class MainCircle extends SimpleCircle {

    public static final int INITIAL_RADIUS = 10;
    public static final int SPEED = 30;

    public MainCircle(int x, int y) {
        super(x, y, INITIAL_RADIUS);
        setColor(Color.BLUE);
    }

    public void moveTo(int x2, int y2) {
        int dx = (x2 - x) * SPEED / GameManager.getScreenWidth();
        int dy = (y2 - y) * SPEED / GameManager.getScreenHeight();
        x += dx;
        y += dy;
    }
}
