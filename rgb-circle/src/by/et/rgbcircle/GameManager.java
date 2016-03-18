package by.et.rgbcircle;

import java.util.ArrayList;

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
    private ArrayList<EnemyCircle> enemyCircles;

    public GameManager(ICanvasView canvasView, int width, int height) {
        this.canvasView = canvasView;
        sScreenHeight = height;
        sScreenWidth = width;
        initializeMainCircle();
        initializeEnemyCircles();
    }

    private void initializeEnemyCircles() {
        enemyCircles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            enemyCircles.add(EnemyCircle.getRandomCircle());
        }
    }

    private void initializeMainCircle() {
        mainCircle = new MainCircle(sScreenWidth / 2, sScreenHeight / 2);
    }

    public void onDraw() {
        canvasView.drawCircle(mainCircle);
        for (EnemyCircle enemyCircle : enemyCircles) {
            canvasView.drawCircle(enemyCircle);
        }
    }

    public void onTouchEvent(int x, int y) {
        mainCircle.moveTo(x, y);
    }

    public static int getScreenWidth() {
        return sScreenWidth;
    }

    public static int getScreenHeight() {
        return sScreenHeight;
    }
}
