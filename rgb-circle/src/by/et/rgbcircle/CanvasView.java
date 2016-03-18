package by.et.rgbcircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * The canvas component to paint.
 * Date: 03/18/2016
 *
 * @author Andrei_Khadziukou
 */
public class CanvasView extends View {

    private MainCircle mainCircle;
    private Paint paint;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeMainCircle();
        initializePaint();
    }

    private void initializePaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    private void initializeMainCircle() {
        mainCircle = new MainCircle(20, 50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mainCircle.getX(), mainCircle.getY(), mainCircle.getRadius(), paint);
    }
}
