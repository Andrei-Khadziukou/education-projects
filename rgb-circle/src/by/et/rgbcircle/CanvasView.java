package by.et.rgbcircle;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * The canvas component to paint.
 * Date: 03/18/2016
 *
 * @author Andrei_Khadziukou
 */
public class CanvasView extends View {

    private GameManager gameManager;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        gameManager = new GameManager();
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        gameManager.onDraw(canvas);
    }
}
