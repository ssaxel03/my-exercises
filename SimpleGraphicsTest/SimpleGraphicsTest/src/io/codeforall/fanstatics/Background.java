package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Background {

    public final int WIDTH = 1920;
    public final int HEIGHT = 1080;

    public Background() {
        Rectangle canvas = new Rectangle(0, 0, WIDTH, HEIGHT);
        canvas.setColor(Color.DARK_GRAY);
        canvas.fill();
    }
}
