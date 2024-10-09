package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class GameManager implements KeyboardHandler {

    Keyboard keyboard;
    private Background background;
    private Player player;
    private Button button;

    public GameManager(Background background, Player player, Button button) {
        this.background = background;
        this.player = player;
        this.button = button;

        keyboardInit();
    }

    public void keyboardInit() {

        keyboard = new Keyboard(this);

        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_D);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_A);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKey(KeyboardEvent.KEY_W);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_S);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent interact = new KeyboardEvent();
        interact.setKey(KeyboardEvent.KEY_E);
        interact.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(moveRight);
        keyboard.addEventListener(moveLeft);
        keyboard.addEventListener(moveUp);
        keyboard.addEventListener(moveDown);
        keyboard.addEventListener(interact);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_D -> player.moveRight();
            case KeyboardEvent.KEY_A -> player.moveLeft();
            case KeyboardEvent.KEY_W -> player.moveUp();
            case KeyboardEvent.KEY_S -> player.moveDown();
            case KeyboardEvent.KEY_E -> this.interact();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void interact() {
        if (player.getPosition()[0] > button.getPosition()[0] &&
                player.getPosition()[1] > button.getPosition()[1] &&
                player.getPosition()[0] + player.getSize() < button.getPosition()[0] + button.getButtonWidth() &&
                player.getPosition()[1] + player.getSize() < button.getPosition()[1] + button.getButtonHeight()
        ) {
            this.button.interact(player);
        }
    }
}
