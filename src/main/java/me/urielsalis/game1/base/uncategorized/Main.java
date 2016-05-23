package me.urielsalis.game1.base.uncategorized;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {

        initDisplay();
        initGL();
        gameLoop();
        cleanUp();
    }

    private static void gameLoop() {
        while(!Display.isCloseRequested()) {
            glClear(GL_COLOR_BUFFER_BIT); //clear color buffer
            glLoadIdentity(); //fixes translate

            glColor3f(0.25f, 0.75f, 0.5f); //set color (optional, default is white)

            //drawRect(56, 56, 32, 256);
            drawRect(400, 400, 224, 32);

            Display.update();

        }
    }

    private static void drawRect(float x, float y, float width, float height) {
        drawRect(x, y, width, height, 0);
    }

    private static void drawRectFromCenter(float x, float y, float width, float height, float rot) {
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

    private static void drawRect(float x, float y, float width, float height, float rot) {
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

    private static void cleanUp() {
        Display.destroy();
    }

    private static void initGL() {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity(); //Clear identity matrix
        glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1); //2D
        glMatrixMode(GL_MODELVIEW);

        glClearColor(0, 0, 0, 1); //black. Its the default but its better to set manually

        glDisable(GL_DEPTH_TEST); //keeps track of all information to make something look good in 3D, so we disable it as its not needed
    }


    private static void initDisplay() {
        //Create display
        try {
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
        } catch (LWJGLException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}
