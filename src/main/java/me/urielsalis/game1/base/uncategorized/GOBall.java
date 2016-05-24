package me.urielsalis.game1.base.uncategorized;

import java.util.Random;

/**
 * @author urielsalis
 */
public class GOBall extends GameObject {

    public static final int SIZE = 16;
    public static final float MAX_SPEEDX = 4f;
    public static final float MAX_SPEEDY = 8f;
    public static final float DAMPING = 0.05f;
    public static int timeout;

    public float velX;
    public float velY;

    public float startX;
    public float startY;

    public GOBall(float x, float y) {
        this.x = x;
        this.y = y;
        this.sx = SIZE;
        this.sy = SIZE;

        this.startX = x;
        this.startY = y;

        velX = ((new Random().nextInt(2) + 1) & 1) == 0 ? -MAX_SPEEDX : MAX_SPEEDX;
        velY = 0;
        timeout = (new Random().nextInt(300) + 1) / 10;
    }

    @Override
    public void update() {
        if (timeout == 0) {
            x += velX;
            y += velY;
        } else {
            timeout--;
        }
    }

    public void reverseX(float center) {
        velX *= -1;
        velY += (getCenterY() - center) * DAMPING;

        if(velY > MAX_SPEEDY) {
            velY = MAX_SPEEDY;
        }
        if(velY < -MAX_SPEEDY) {
            velY = -MAX_SPEEDY;
        }
    }

    public void reverseY() {
        velY *= -1;
    }

    public void resetPosition() {
        x = startX;
        y = startY;

        velX = ((new Random().nextInt(2) + 1) & 1) == 0 ? -MAX_SPEEDX : MAX_SPEEDX;
        velY = 0;
        timeout = (new Random().nextInt(300) + 1) / 10;
    }
}
