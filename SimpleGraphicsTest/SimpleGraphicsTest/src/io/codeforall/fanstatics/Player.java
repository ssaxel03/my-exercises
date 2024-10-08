package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.sql.SQLOutput;

public class Player implements KeyboardHandler {

    private Color color;
    private int size;
    Rectangle playerSprite;
    Keyboard keyboard;

    public Player(int size){
        this.color = Color.ORANGE;
        this.size = size;

        keyboardInit();

        this.playerSprite = new Rectangle(10, 10, size, size);
        this.playerSprite.setColor(color);
        this.playerSprite.fill();
    }

    public void keyboardInit() {

        keyboard = new Keyboard(this);

        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_D);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_A);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(moveRight);
        keyboard.addEventListener(moveLeft);

    }

    public void moveRight() {
        this.playerSprite.translate(10, 0);
        System.out.println("AQUI");
    }

    public void moveLeft() {
        this.playerSprite.translate(-10, 0);
    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch(keyboardEvent.getKey()){
            case KeyboardEvent.KEY_D -> moveRight();
            case KeyboardEvent.KEY_A -> moveLeft();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
