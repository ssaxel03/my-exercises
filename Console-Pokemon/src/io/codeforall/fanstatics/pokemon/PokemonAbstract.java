package io.codeforall.fanstatics.pokemon;

import java.util.Set;

public abstract class PokemonAbstract implements Pokemon {

    private String name;
    private PokemonType type;
    private Set<Move> moveSet;

    private int health;
    private int attack;
    private int defense;
    private int speed;

    public PokemonAbstract(String name, PokemonType type, Set<Move> moveSet, int health, int attack, int defense, int speed) {
        this.name = name;
        this.type = type;
        this.moveSet = moveSet;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    public void attack(Pokemon target, Move move) {

        if(Math.random() > (move.getAccuracy() / 100)) {
            target.hit(this, move.getAttack());
            return;
        }

        System.out.println("Move failed");
    }

    public void hit(Pokemon attacker, int damage) {

        this.health -= (damage * PokemonType.getMultiplier(attacker, this)) + this.defense;

    }

    public PokemonType getType() {
        return this.type;
    }
}
