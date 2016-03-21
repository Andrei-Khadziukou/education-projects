package by.et.rgbcircle;

import android.graphics.Color;

import java.util.Random;

/**
 * The circle to emulate food and enemy players.
 * Date: 03/18/2016
 *
 * @author Andrei_Khadziukou
 */
public class EnemyCircle extends SimpleCircle {

    public static final int ENEMY_COLOR = Color.RED;
    public static final int FOOD_COLOR = Color.rgb(0, 208, 0);
    public static final int SPEED = 10;

    private int dx;
    private int dy;

    public EnemyCircle(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;
    }

    public static EnemyCircle getRandomCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getScreenWidth());
        int y = random.nextInt(GameManager.getScreenHeight());
        int radius = 5 + random.nextInt(Math.min(GameManager.getScreenWidth(), GameManager.getScreenHeight()) / 20);
        int dx = 1 + random.nextInt(SPEED);
        int dy = 1 + random.nextInt(SPEED);
        EnemyCircle enemyCircle = new EnemyCircle(x, y, radius, dx, dy);
        return enemyCircle;
    }

    public void setColorDependsOnFoodOrEnemy(MainCircle mainCircle) {
        if (isSmallThan(mainCircle)) {
            setColor(FOOD_COLOR); // green
        } else {
            setColor(ENEMY_COLOR);
        }
    }

    private boolean isSmallThan(MainCircle mainCircle) {
        return this.radius <= mainCircle.radius;
    }

    public void moveOnStep() {
        x += dx;
        y += dy;
    }
}
