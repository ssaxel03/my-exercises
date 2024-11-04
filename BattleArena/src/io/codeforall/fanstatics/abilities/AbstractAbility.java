package io.codeforall.fanstatics.abilities;

public abstract class AbstractAbility implements Ability{

    private int power;
    private int manaCost;
    int coolDownTurns;
    int lastUsed;
    private String name;

    public AbstractAbility(int power, int manaCost, int coolDownTurns, String name) {
        this.power = power;
        this.manaCost = manaCost;
        this.name = name;
        this.coolDownTurns = coolDownTurns;
        this.lastUsed = - coolDownTurns - 1;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setLastUsed(int lastUsed) {this.lastUsed = lastUsed;}

    public boolean isAvailable(int currentTurn, int currentMana) {
        return currentTurn - lastUsed > coolDownTurns && currentMana >= manaCost;
    }
}
