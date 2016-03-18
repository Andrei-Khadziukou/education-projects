package by.et.rgbcircle;

import java.util.Random;

/**
 * Date: 03/18/2016
 *
 * @author Andrei_Khadziukou
 */
public class EnemyCircle extends SimpleCircle {

    public EnemyCircle(int x, int y, int radius) {
        super(x, y, radius);
    }

    public static EnemyCircle getRandomCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getScreenWidth());
        int y = random.nextInt(GameManager.getScreenHeight());
        int radius = 10 + random.nextInt(Math.min(GameManager.getScreenWidth(), GameManager.getScreenHeight()) / 20);
        return new EnemyCircle(x, y, radius);
    }
}
