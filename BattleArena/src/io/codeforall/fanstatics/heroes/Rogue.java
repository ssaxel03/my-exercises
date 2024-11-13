package io.codeforall.fanstatics.heroes;

import io.codeforall.fanstatics.abilities.SneakAttack;

public class Rogue extends Hero {
    public Rogue() {
        super(100, 30, 10, 70, 40, new SneakAttack(30), "ROGUE");
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
