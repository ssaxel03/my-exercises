package io.codeforall.fanstatics.abilities;

import io.codeforall.fanstatics.heroes.Hero;

public interface Ability {

    public void use(int currentTurn, Hero target);
    public boolean isAvailable(int currentTurn, int currentMana);
    public String getName();
    public int getPower();

}
