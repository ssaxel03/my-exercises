package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.sql.SQLOutput;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Player {

    private Color color;
    private int size;
    Rectangle playerSprite;
    Keyboard keyboard;
    // final ScheduledExecutorService executorService;

    public Player(int size) {
        this.color = Color.ORANGE;
        this.size = size;

        /*
        Runnable moveRight = new Runnable() {
            @Override
            public void run() {
                moveRight();
            }
        };
         */

        //executorService = Executors.newSingleThreadScheduledExecutor();
        // executorService.scheduleAtFixedRate(moveRight, 0, 100, TimeUnit.MILLISECONDS);

        this.playerSprite = new Rectangle(10, 900, size, size);
        this.playerSprite.setColor(color);
        this.playerSprite.fill();
    }

    public void moveRight() {
        this.playerSprite.translate(20, 0);
    }

    public void moveLeft() {
        this.playerSprite.translate(-20, 0);
    }

    public void moveUp() {
        this.playerSprite.translate(0, -20);
    }

    public void moveDown() {
        this.playerSprite.translate(0, 20);
    }

    public int getSize() {
        return size;
    }

    public int[] getPosition() {
        return new int[] {playerSprite.getX(), playerSprite.getY()};
    }
}
