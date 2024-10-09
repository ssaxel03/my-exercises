package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Main {

    public static void main(String[] args) {

        Background background = new Background();

        Button button = new Button("O Mekie é totó", Color.RED, background, 500, 200);

        Player player = new Player(100);

        Text text = new Text(300, 300, "PRESS E TO INTERACT");
        text.setColor(Color.WHITE);
        text.grow(150, 50);
        text.draw();

        GameManager gameManager = new GameManager(background, player, button);
    }

}
