package by.et.rgbcircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * The canvas component to paint.
 * Date: 03/18/2016
 *
 * @author Andrei_Khadziukou
 */
public class CanvasView extends View {

    private static int sScreenWidth;
    private static int sScreenHeight;

    private GameManager gameManager;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeScreenWidthAndHeight(context);
        gameManager = new GameManager(this, sScreenWidth, sScreenHeight);
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


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        gameManager.onDraw(canvas);
    }
}
