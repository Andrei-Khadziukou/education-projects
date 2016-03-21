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

    public EnemyCircle(int x, int y, int radius) {
        super(x, y, radius);
    }

    public static EnemyCircle getRandomCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getScreenWidth());
        int y = random.nextInt(GameManager.getScreenHeight());
        int radius = 5 + random.nextInt(Math.min(GameManager.getScreenWidth(), GameManager.getScreenHeight()) / 20);
        EnemyCircle enemyCircle = new EnemyCircle(x, y, radius);
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
}
