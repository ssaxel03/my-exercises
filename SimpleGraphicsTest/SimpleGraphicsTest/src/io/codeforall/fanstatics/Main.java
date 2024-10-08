package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {

    public static void main(String[] args) {

        Rectangle canvas = new Rectangle(0, 0, 1920, 1080);
        canvas.draw();

        Player player = new Player(100);
    }

}
