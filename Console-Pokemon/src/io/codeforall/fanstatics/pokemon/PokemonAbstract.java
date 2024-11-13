package io.codeforall.fanstatics.pokemon;

import java.util.ArrayList;
import java.util.Set;

public abstract class PokemonAbstract implements Pokemon {

    private String name;
    private PokemonType type;
    private ArrayList<Move> moveSet;

    private int health;
    private int attack;
    private int defense;
    private int speed;

    public PokemonAbstract(String name, PokemonType type, ArrayList<Move> moveSet, int health, int attack, int defense, int speed) {
        this.name = name;
        this.type = type;
        this.moveSet = moveSet;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    public void attack(Pokemon target, Move move) {

        System.out.println(this.name + " uses " + move.toString() + " on " + target.getName());
        move.decLimit();

        if(Math.random() < ((float) move.getAccuracy() / 100)) {
            target.hit(this, move);
            return;
        }

        System.out.println("Attack missed");
    }

    public void hit(Pokemon attacker, Move move) {

        int damage = (int) ((move.getAttack() * PokemonType.getMultiplier(move.getType(), this.getType())) - this.defense / 10);

        System.out.println(attacker.getName() + " dealt " + damage + " damage to " + this.getName());
        this.health = damage > health ? 0 : health - damage;

    }

    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public PokemonType getType() {
        return this.type;
    }
    @Override
    public Move getMove(int moveIndex) {
        return this.moveSet.get(moveIndex);
    }
    @Override
    public String[] getMoves() {
        return new String[] {
                getMoveDescription(0),
                getMoveDescription(1),
                getMoveDescription(2),
                getMoveDescription(3)
        };
    }
    private String getMoveDescription(int index) {
        return this.getMove(index).toString() +
                " - damage " + this.getMove(index).getAttack() +
                " accuracy " + this.getMove(index).getAccuracy() +
                " type " + this.getMove(index).getType() +
                " limit " + this.getMove(index).getLimit();
    }
    @Override
    public int getSpeed() {
        return this.speed;
    }
    @Override
    public String getDescription() {
        return this.name + " HP " + this.health;
    }
    @Override
    public boolean isDead() {
        return health == 0;
    }
    @Override
    public int getHealth() {
        return this.health;
    }
}
