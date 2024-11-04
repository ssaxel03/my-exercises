package io.codeforall.fanstatics.heroes;

import io.codeforall.fanstatics.abilities.Fireball;

public class Mage extends Hero {
    public Mage() {
        super(100, 40, 25, 200, 100, new Fireball(), "Mage");
    }

    @Override
    public void play(int currentTurn, Hero target) {
        if(!this.isAlive()) {
            return;
        }
        this.mana += this.manaRecovery;

        if (this.ability.isAvailable(currentTurn, this.mana)) {
            this.ability.use(currentTurn, target);
        } else {
            this.attack(target);
        }
    }
}
