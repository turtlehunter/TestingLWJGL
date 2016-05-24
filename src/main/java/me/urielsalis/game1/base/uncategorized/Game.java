package me.urielsalis.game1.base.uncategorized;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import java.security.Key;
import java.util.ArrayList;

/**
 * @author urielsalis
 */
public class Game {
    private ArrayList<GameObject> objects;

    private GOPlayer player;
    private GOBall ball;
    private GOEnemy enemy;
    private int playerScore;
    private int enemyScore;

    public Game() {
        objects = new ArrayList<GameObject>();

        playerScore = 0;
        enemyScore = 0;

        ball = new GOBall(Display.getWidth()/2 - GOBall.SIZE / 2, Display.getHeight()/2 - GOBall.SIZE / 2);
        player = new GOPlayer(0, (Display.getHeight() / 2 - GOPlayer.SIZEY / 2 ), ball);
        enemy = new GOEnemy(Display.getWidth() - GOEnemy.SIZEX, (Display.getHeight() / 2 - GOPlayer.SIZEY / 2 ), ball);
        GOWall wall1 = new GOWall(0, 0, Display.getWidth(), GOWall.STDSIZE, ball);
        GOWall wall2 = new GOWall(0, Display.getHeight() - GOWall.STDSIZE, Display.getWidth(), GOWall.STDSIZE, ball);

        objects.add(0, ball);
        objects.add(player);
        objects.add(enemy);
        objects.add(wall1);
        objects.add(wall2);
    }

    public void getInput() {
        if(Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_UP)) player.move(1);
        if(Keyboard.isKeyDown(Keyboard.KEY_S) || Keyboard.isKeyDown(Keyboard.KEY_DOWN)) player.move(-1);

    }

    public void update() {
        for (GameObject go : objects) {
            go.update();
        }

        if (ball.getX() > Display.getWidth()) {
            playerScore++;
            ball.resetPosition();
        }
        else if(ball.getX() < 0) {
            enemyScore++;
            ball.resetPosition();
        }
    }

    public void render() {
        for(GameObject go: objects) {
            go.render();
        }

        Display.setTitle("Score: P: " + playerScore + " E: " + enemyScore);
    }
}
