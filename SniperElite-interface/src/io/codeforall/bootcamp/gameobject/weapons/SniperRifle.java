package io.codeforall.bootcamp.gameobject.weapons;

import io.codeforall.bootcamp.gameobject.Destroyable;

/**
 * A sniper rifle used to kill enemies
 */
public class SniperRifle {

    public static final double HIT_PROBABILITY = 0.7;

    private int shotsFired;
    private int bulletDamage;

    /**
     * Constructs a snipper rifle
     * @param bulletDamage the amount of damaged caused by each shot
     */
    public SniperRifle(int bulletDamage) {
        this.bulletDamage = bulletDamage;
    }

    public int getShotsFired() {
        return shotsFired;
    }

    /**
     * Take a shoot at an enemy
     * @param target the enemy to shoot
     */
    public void shoot(Destroyable target) {

        shotsFired++;

        if(Math.random() < HIT_PROBABILITY) {

            target.hit(bulletDamage);
            System.out.println("It's a hit!");

        } else {
            System.out.println("It's a miss!");
        }

    }
}
