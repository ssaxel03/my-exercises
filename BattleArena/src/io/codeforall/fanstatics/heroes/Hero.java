package io.codeforall.fanstatics.heroes;

import io.codeforall.fanstatics.abilities.Ability;

public abstract class Hero {

    private final String name;
    int health;
    private int attack;
    private int defense;
    int mana;
    int manaRecovery;
    private boolean isAlive;
    Ability ability;

    public Hero(int health, int attack, int defense, int mana, int manaRecovery, Ability ability, String name) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.mana = mana;
        this.manaRecovery = manaRecovery;
        this.isAlive = true;
        this.ability = ability;
        this.name = name;
    }


    public void hit(int damage) {
        this.health -= damage;
        if(health <= 0) {
            System.out.println(this.getName() + " IS DEAD");
            this.die();
        }
    }

    public void raiseDefense(int amount) {
        this.defense += amount;
    }
    void attack(Hero target) {

        System.out.println(this.getName() + " USES PAULADA ON " + target.getName());
        target.hit(this.attack - target.defense);
    }
    public abstract void play(int currentTurn, Hero target);

    protected void die() {
        this.isAlive = false;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public String getName() {
        return this.name;
    }
}
