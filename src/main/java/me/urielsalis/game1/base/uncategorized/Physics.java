package me.urielsalis.game1.base.uncategorized;

import java.awt.*;

/**
 * @author urielsalis
 */
public class Physics {
    public static boolean checkCollissions(GameObject go1, GameObject go2) {
        Rectangle r1 = new Rectangle((int) go1.getX(), (int) go1. getY(), (int) go1.getSx(), (int) go1.getSy());
        Rectangle r2 = new Rectangle((int) go2.getX(), (int) go2. getY(), (int) go2.getSx(), (int) go2.getSy());

        return r1.intersects(r2);
    }
}
