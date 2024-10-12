package io.codeforall.bootcamp.car;

import io.codeforall.bootcamp.grid.GridDirection;
import io.codeforall.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class PlayerCar extends Car implements KeyboardHandler {
    public final static int SPEED = 3;
    public GridDirection direction;
    public Keyboard keyboard;

    /**
     * Constructs a brand new PlayerCar
     *
     * @param pos the position of the car in the grid
     */
    public PlayerCar(GridPosition pos) {
        super(pos, CarType.PLAYER);
        this.keyboardInit();
    }

    public void keyboardInit() {
        keyboard = new Keyboard(this);

        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKey(KeyboardEvent.KEY_W);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_S);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_A);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_D);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(moveUp);
        keyboard.addEventListener(moveDown);
        keyboard.addEventListener(moveLeft);
        keyboard.addEventListener(moveRight);

    }

    /**
     * @see Car#move()
     */
    @Override
    public void move() {

        // accelerate(direction, PlayerCar.SPEED);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
       switch(keyboardEvent.getKey()){
           case KeyboardEvent.KEY_W:
               this.direction = GridDirection.UP;
               accelerate(direction, PlayerCar.SPEED);
               break;
           case KeyboardEvent.KEY_S:
               this.direction = GridDirection.DOWN;
               accelerate(direction, PlayerCar.SPEED);
               break;
           case KeyboardEvent.KEY_A:
               this.direction = GridDirection.LEFT;
               accelerate(direction, PlayerCar.SPEED);
               break;
           case KeyboardEvent.KEY_D:
               this.direction = GridDirection.RIGHT;
               accelerate(direction, PlayerCar.SPEED);
               break;
       }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
