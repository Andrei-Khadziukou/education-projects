package by.et.rgbcircle;

/**
 * The game manage to hold process of the game.
 * Date: 03/18/2016
 *
 * @author Andrei_Khadziukou
 */
public class GameManager {

    private static int sScreenWidth;
    private static int sScreenHeight;

    private ICanvasView canvasView;
    private MainCircle mainCircle;

    public GameManager(ICanvasView canvasView, int width, int height) {
        this.canvasView = canvasView;
        sScreenHeight = height;
        sScreenWidth = width;
        initializeMainCircle();
    }

    private void initializeMainCircle() {
        mainCircle = new MainCircle(sScreenWidth / 2, sScreenHeight / 2);
    }

    public void onDraw() {
        canvasView.drawCircle(mainCircle);
    }
}
