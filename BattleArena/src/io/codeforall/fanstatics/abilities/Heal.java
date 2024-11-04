package io.codeforall.fanstatics.abilities;

import io.codeforall.fanstatics.heroes.Hero;

public class Heal extends AbstractAbility {
    public Heal() {
        super(60, 50, 5, "Heal");
    }

    @Override
    public void use(int currentTurn, Hero target) {
        System.out.println("CLERIC HEALS HIMSELF");
        this.setLastUsed(currentTurn);
        target.hit(- this.getPower());
    }
}
