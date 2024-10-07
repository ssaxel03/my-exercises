package io.codeforall.bootcamp;

public class ArmouredEnemy extends Enemy{
    private int armour;

    public ArmouredEnemy() {
        this.armour = 100;
    }

    @Override
    public void hit(int hitAmount, boolean headshot) {



        if(this.armour == 0) {
            super.hit(hitAmount, headshot);
            return;
        }

        int healthDamage = this.armour - hitAmount;

        if(healthDamage >= 0) {
            this.armour -= hitAmount;
            System.out.printf(headshot ? "%s has been hit in the head (%d health)%n" : "%s has been hit (%d health)%n", this.toString(), this.getHealthLeft());
            return;
        }

        this.armour = 0;
        super.hit(healthDamage * -1, headshot);

    }

    @Override
    public int getHealthLeft() {
        return super.getHealthLeft() + this.armour;
    }

    @Override
    public String toString() {
        return "Armoured Enemy";
    }
}
