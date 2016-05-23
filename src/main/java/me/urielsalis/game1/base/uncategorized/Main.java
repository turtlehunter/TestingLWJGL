package me.urielsalis.game1.base.uncategorized;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    private static Game game;

    public static void main(String[] args) {
        //Step 1: Initialize program
        initDisplay();
        initGL();

        //Step 2: Initialize game
        initGame();

        //Step 3: Start game loop
        gameLoop();

        //Step 7: Cleanup
        cleanUp();
    }

    private static void initGame() {
        game = new Game();
    }

    private static void getInput() {
        game.getInput();
    }

    private static void update() {
        game.update();
    }

    private static void render() {
        glClear(GL_COLOR_BUFFER_BIT); //clear color buffer
        glLoadIdentity(); //fixes translate

        game.render();

        Display.update();
        Display.sync(60);
    }

    private static void gameLoop() {
        while(!Display.isCloseRequested()) {
            //Step 4: Get user input
            getInput();

            //Step 5: Update logic
            update();

            //Step 6: Render
            render();
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
            Display.setVSyncEnabled(true);
        } catch (LWJGLException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}
