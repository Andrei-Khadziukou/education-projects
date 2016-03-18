package by.et.rgbcircle;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * The game manage to hold process of the game.
 * Date: 03/18/2016
 *
 * @author Andrei_Khadziukou
 */
public class GameManager {

    private MainCircle mainCircle;
    private Paint paint;

    public GameManager() {
        initializeMainCircle();
        initializePaint();
    }

    private void initializePaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    private void initializeMainCircle() {
        mainCircle = new MainCircle(50, 100);
    }

    public void onDraw(Canvas canvas) {
        canvas.drawCircle(mainCircle.getX(), mainCircle.getY(), mainCircle.getRadius(), paint);
    }
}
