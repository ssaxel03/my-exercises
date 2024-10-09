package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Button implements Interactable{

    private String message;
    private Color color;
    private Rectangle buttonSprite;
    private int buttonWidth;
    private int buttonHeight;
    private int positionX = 500;
    private int positionY = 500;

    public Button(String message, Color color, Background background, int buttonWidth, int buttonHeight) {
        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;
        this.message = message;
        this.color = color;

        buttonSprite = new Rectangle(500, 500, this.buttonWidth, this.buttonHeight);
        buttonSprite.setColor(this.color);
        buttonSprite.fill();
    }

    public void interact(Player player) {
        System.out.println("AQUIIIIII");
        Text text = new Text(1450, 600, this.message);
        text.setColor(Color.WHITE);
        text.draw();
        text.grow(400, 80);
    }

    public int getButtonWidth() {
        return this.buttonWidth;
    }

    public int getButtonHeight() {
        return this.buttonHeight;
    }

    public int[] getPosition() {
        return new int[] {this.positionX, this.positionY};
    }

}
