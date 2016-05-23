package me.urielsalis.game1.base.uncategorized;

import static org.lwjgl.opengl.GL11.*;

/**
 * @author urielsalis
 */
public class Draw {
    public static void rect(float x, float y, float width, float height) {
        rect(x, y, width, height, 0);
    }

    public static void rectFromCenter(float x, float y, float width, float height, float rot) {
        glPushMatrix(); //stack. Unique matrix per rectangle so its correct position
        {
            width /= 2; //to draw on center
            height /= 2;


            glTranslatef(x, y, 0); //move everything certain amount. 1,0,0 makes funny animation :P
            glRotatef(rot, 0, 0, 1); //Z always point to camera

            glBegin(GL_QUADS);
            { //not needed but looks nicer
                glVertex2f(-width, -height); //replace 0 with negative to draw on center
                glVertex2f(-width, height); //make points
                glVertex2f(width, height);
                glVertex2f(width, -height);
            }
            glEnd();
        }
        glPopMatrix();
    }

    public static void rect(float x, float y, float width, float height, float rot) {
        glPushMatrix(); //stack. Unique matrix per rectangle so its correct position
        {
            glTranslatef(x, y, 0); //move everything certain amount. 1,0,0 makes funny animation :P
            glRotatef(rot, 0, 0, 1); //Z always point to camera

            glBegin(GL_QUADS);
            { //not needed but looks nicer
                glVertex2f(0, 0);
                glVertex2f(0, height); //make points
                glVertex2f(width, height);
                glVertex2f(width, 0);
            }
            glEnd();
        }
        glPopMatrix();
    }
}
