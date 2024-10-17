package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class InputManager implements KeyboardHandler {

    private Keyboard keyboard;

    private int moveUp;
    private int moveDown;
    private int moveLeft;
    private int moveRight;
    private boolean space;
    private boolean clear;
    private boolean save;
    private boolean load;

    public InputManager() {
        moveUp = 0;
        moveDown = 0;
        moveLeft = 0;
        moveRight = 0;
        space = false;
        clear = false;
        save = false;
    }

    public void init() {
        this.keyboardInit();
    }

    private void keyboardInit() {
        this.keyboard = new Keyboard(this);

        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKey(KeyboardEvent.KEY_UP);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(moveUp);
        keyboard.addEventListener(moveDown);
        keyboard.addEventListener(moveLeft);
        keyboard.addEventListener(moveRight);

        KeyboardEvent moveUpRelease = new KeyboardEvent();
        moveUpRelease.setKey(KeyboardEvent.KEY_UP);
        moveUpRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent moveDownRelease = new KeyboardEvent();
        moveDownRelease.setKey(KeyboardEvent.KEY_DOWN);
        moveDownRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        ;KeyboardEvent moveLeftRelease = new KeyboardEvent();
        moveLeftRelease.setKey(KeyboardEvent.KEY_LEFT);
        moveLeftRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent moveRightRelease = new KeyboardEvent();
        moveRightRelease.setKey(KeyboardEvent.KEY_RIGHT);
        moveRightRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(moveUpRelease);
        keyboard.addEventListener(moveDownRelease);
        keyboard.addEventListener(moveLeftRelease);
        keyboard.addEventListener(moveRightRelease);

        KeyboardEvent paint = new KeyboardEvent();
        paint.setKey(KeyboardEvent.KEY_SPACE);
        paint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent paintRelease = new KeyboardEvent();
        paintRelease.setKey(KeyboardEvent.KEY_SPACE);
        paintRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(paint);
        keyboard.addEventListener(paintRelease);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKey(KeyboardEvent.KEY_C);
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent clearRelease = new KeyboardEvent();
        clearRelease.setKey(KeyboardEvent.KEY_C);
        clearRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(clear);
        keyboard.addEventListener(clearRelease);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent saveRelease = new KeyboardEvent();
        saveRelease.setKey(KeyboardEvent.KEY_S);
        saveRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(save);
        keyboard.addEventListener(saveRelease);

        KeyboardEvent load = new KeyboardEvent();
        load.setKey(KeyboardEvent.KEY_L);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent loadRelease = new KeyboardEvent();
        loadRelease.setKey(KeyboardEvent.KEY_L);
        loadRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(load);
        keyboard.addEventListener(loadRelease);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP -> moveUp = 1;
            case KeyboardEvent.KEY_DOWN -> moveDown = 1;
            case KeyboardEvent.KEY_LEFT -> moveLeft = 1;
            case KeyboardEvent.KEY_RIGHT -> moveRight = 1;
            case KeyboardEvent.KEY_SPACE -> space = true;
            case KeyboardEvent.KEY_C -> clear = true;
            case KeyboardEvent.KEY_S -> save = true;
            case KeyboardEvent.KEY_L -> load = true;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP -> moveUp = 0;
            case KeyboardEvent.KEY_DOWN -> moveDown = 0;
            case KeyboardEvent.KEY_LEFT -> moveLeft = 0;
            case KeyboardEvent.KEY_RIGHT -> moveRight = 0;
            case KeyboardEvent.KEY_SPACE -> space = false;
            case KeyboardEvent.KEY_C -> clear = false;
            case KeyboardEvent.KEY_S -> save = false;
            case KeyboardEvent.KEY_L -> load = false;
        }
    }

    public int getMoveUp() {
        return this.moveUp;
    }

    public int getMoveDown() {
        return this.moveDown;
    }

    public int getMoveLeft() {
        return this.moveLeft;
    }

    public int getMoveRight() {
        return this.moveRight;
    }
    public boolean getSpace() {
        return this.space;
    }
    public boolean getClear() {
        return this.clear;
    }

    public boolean getSave() {
        return this.save;
    }
    public boolean getLoad() {
        return this.load;
    }
}
