package io.codeforall.fanstatics.heroes;

import io.codeforall.fanstatics.abilities.Heal;

public class Cleric extends Hero {
    public Cleric() {
        super(90, 45, 20, 150, 90, new Heal(), "CLERIC");
    }

    @Override
    public void play(int currentTurn, Hero target) {
        if(!this.isAlive()) {
            return;
        }
        this.mana += this.manaRecovery;

        if (this.ability.isAvailable(currentTurn, this.mana)) {
            this.ability.use(currentTurn, this);
        } else {
            this.attack(target);
        }
    }
}
