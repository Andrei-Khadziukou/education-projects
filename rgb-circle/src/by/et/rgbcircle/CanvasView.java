package by.et.rgbcircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/**
 * The canvas component to paint.
 * Date: 03/18/2016
 *
 * @author Andrei_Khadziukou
 */
public class CanvasView extends View implements ICanvasView {

    private static int sScreenWidth;
    private static int sScreenHeight;

    private GameManager gameManager;
    private Paint paint;
    private Canvas canvas;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeScreenWidthAndHeight(context);
        gameManager = new GameManager(this, sScreenWidth, sScreenHeight);
        initializePaint();
    }

    private void initializeScreenWidthAndHeight(Context context) {
        // to get width and height of the screen
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        sScreenWidth = point.x;
        sScreenHeight = point.y;
    }

    private void initializePaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        gameManager.onDraw();
    }

    @Override
    public void drawCircle(SimpleCircle circle) {
        paint.setColor(circle.getColor());
        canvas.drawCircle(circle.getX(), circle.getY(), circle.getRadius(), paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        if (MotionEvent.ACTION_MOVE == event.getAction()) {
            gameManager.onTouchEvent(x, y);
        }
        // to repaint view
        invalidate();
        return true;
    }
}
