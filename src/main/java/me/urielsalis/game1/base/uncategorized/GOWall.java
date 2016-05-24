package me.urielsalis.game1.base.uncategorized;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.Rectangle;

/**
 * @author urielsalis
 */
public class GOWall extends GameObject {
    public static final int STDSIZE = 16;
    private GOBall ball;

    public GOWall(float x, float y, float sx, float sy, GOBall ball) {
        this.x = x;
        this.y = y;
        this.sx = sx;
        this.sy = sy;
        this.ball = ball;
    }

    @Override
    public void update() {
        if(Physics.checkCollissions(this, ball)) {
            ball.reverseY();
        }
    }
}