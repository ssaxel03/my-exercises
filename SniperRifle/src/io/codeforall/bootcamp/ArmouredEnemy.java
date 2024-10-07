package io.codeforall.bootcamp;

public class ArmouredEnemy extends Enemy{
    private int armour;

    public ArmouredEnemy() {
        this.armour = 100;
    }

    @Override
    public void hit(int hitAmount) {
        if(this.armour == 0) {
            super.hit(hitAmount);
            return;
        }

        int healthDamage = this.armour - hitAmount;

        if(healthDamage >= 0) {
            this.armour -= hitAmount;
            return;
        }

        this.armour = 0;
        super.hit(healthDamage * -1);

    }

    @Override
    public String toString() {
        return "Armoured Enemy";
    }
}
