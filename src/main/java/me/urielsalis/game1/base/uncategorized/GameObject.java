package me.urielsalis.game1.base.uncategorized;

/**
 * @author urielsalis
 */
public abstract class GameObject {
    protected float x;
    protected float y;
    protected float sx;
    protected float sy;

    public abstract void update();

    public void render() {
        Draw.rect(x, y, sx, sy);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSx() {
        return sx;
    }

    public void setSx(float sx) {
        this.sx = sx;
    }

    public float getSy() {
        return sy;
    }

    public void setSy(float sy) {
        this.sy = sy;
    }

    public float getCenterY() {
        return sy/2 + y;
    }
}
