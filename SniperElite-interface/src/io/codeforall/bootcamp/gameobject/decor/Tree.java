package io.codeforall.bootcamp.gameobject.decor;

import io.codeforall.bootcamp.gameobject.GameObject;

/**
 * A simple tree, not worthy of getting shot
 */
public class Tree extends GameObject {

    /**
     * @see GameObject#getMessage()
     */
    @Override
    public String getMessage() {
        return "Just a Tree. Save the Trees!";
    }

}
