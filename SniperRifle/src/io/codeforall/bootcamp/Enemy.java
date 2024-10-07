package io.codeforall.bootcamp;

public abstract class Enemy extends GameObject{

    private int health;
    private boolean isDead;

    public Enemy() {
        this.health = 100;
        this.isDead = false;
    }

    public boolean isDead() {
        return this.isDead;
    }

    public int getHealthLeft() {
        return this.health;
    }

    public void hit(int hitAmount) {

        this.health -= hitAmount;

        if(health <= 0) {
            this.isDead = true;
        }



    }

    public void hit(int hitAmount, boolean headshot) {

        this.health -= hitAmount;

        if(this.health <= 0) {
            this.isDead = true;
            this.health = 0;
        }

        System.out.printf(headshot ? "%s has been hit in the head (%d health)%n" : "%s has been hit (%d health)%n", toString(), this.health);

    }

    public String getMessage() {
        return "I'm an enemy";
    }

}
