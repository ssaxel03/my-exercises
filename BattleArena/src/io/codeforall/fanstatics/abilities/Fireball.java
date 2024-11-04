package io.codeforall.fanstatics.abilities;

import io.codeforall.fanstatics.heroes.Hero;

public class Fireball extends AbstractAbility{
    public Fireball() {
        super(150, 230, 9,"Fireball");
    }

    @Override
    public void use(int currentTurn, Hero target) {
        System.out.println("MAGE USES FIREBALL ON " + target.getName());
        this.setLastUsed(currentTurn);
        target.hit(this.getPower());
    }
}
