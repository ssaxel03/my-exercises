package io.codeforall.fanstatics.abilities;

import io.codeforall.fanstatics.heroes.Hero;

public class SneakAttack extends AbstractAbility {
    public SneakAttack(int basePower) {
        super(basePower, 110, 16, "Sneak Attack");
    }

    @Override
    public void use(int currentTurn, Hero target) {
        System.out.println("ROGUE USES SNEAK ATTACK ON " + target.getName());
        target.hit(Math.random() > 0.5d ? this.getPower() : this.getPower() * 2);
    }
}
