package io.codeforall.bootcamp.gameobject.enemy;

import io.codeforall.bootcamp.gameobject.Destroyable;
import io.codeforall.bootcamp.gameobject.GameObject;

/**
 * An enemy class containing generic enemy functionality and meant for subclassing
 */
public abstract class Enemy extends GameObject implements Destroyable {

    private int health;
    private boolean destroyed;
    /**
     * Generic enemy constructor
     * @param health the initial health
     */
    public Enemy(int health) {
        this.health = health;
        this.destroyed = false;
    }

    public int getHealth() {
        return health;
    }

    public boolean isDead() {
        return health <= 0;
    }

    /**
     * Removes health according to the hit damage
     * @param damage the damage impact
     */
    public void hit(int damage) {

        health = health - damage > 0 ? health - damage : 0;

        if(health == 0) {
            this.destroyed = true;
        }
    }

    @Override
    public boolean isDestroyed() {
        return this.destroyed;
    }

    @Override
    public void burn() {
        this.health = 0;
        this.destroyed = true;
        System.out.println("A soldier is burning");
    }

    /**
     * @see GameObject#getMessage()
     */
    @Override
    public String getMessage() {
        return "Soldier spotted. Taking it down!";
    }

}
