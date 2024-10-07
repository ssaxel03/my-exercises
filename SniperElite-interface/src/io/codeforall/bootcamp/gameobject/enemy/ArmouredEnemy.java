package io.codeforall.bootcamp.gameobject.enemy;

/**
 * An enemy with an armour
 */
public class ArmouredEnemy extends Enemy {

    private int armour;

    /**
     * Constructs an armoured enemy
     * @param health the initial health
     * @param armour the initial armour
     */
    public ArmouredEnemy(int health, int armour) {
        super(health);
        this.armour = armour;
    }

    /**
     * Damage hits armour, if armour is lost it proceeds to take damage
     * @see Enemy#hit(int)
     */
    @Override
    public void hit(int damage) {

        if (armour > damage) {
            armour -= damage;
            return;
        }

        damage -= armour;
        armour = 0;
        super.hit(damage);

    }

}
