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

    private static int sScreenWidth;
    private static int sScreenHeight;

    private CanvasView canvasView;
    private MainCircle mainCircle;
    private Paint paint;

    public GameManager(CanvasView canvasView, int width, int height) {
        this.canvasView = canvasView;
        sScreenHeight = height;
        sScreenWidth = width;
        initializeMainCircle();
        initializePaint();
    }

    private void initializePaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    private void initializeMainCircle() {
        mainCircle = new MainCircle(sScreenWidth / 2, sScreenHeight / 2);
    }

    public void onDraw(Canvas canvas) {
        canvas.drawCircle(mainCircle.getX(), mainCircle.getY(), mainCircle.getRadius(), paint);
    }
}
