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

            glColor3f(0.25f, 0.75f, 0.5f); //set color (optional, default is white)

            glBegin(GL_QUADS);
            { //not needed but looks nicer
                glVertex2f(0, 0);
                glVertex2f(0, 64); //make points
                glVertex2f(64, 64);
                glVertex2f(64, 0);
            }
            glEnd();

            Display.update();
        }
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
