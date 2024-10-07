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

    public void hit(int hitAmount) {

        this.health -= hitAmount;

        if(health <= 0) {
            this.isDead = true;
        }

    }

    public String getMessage() {
        return "I'm an enemy";
    }

}
