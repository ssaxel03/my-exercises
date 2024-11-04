package io.codeforall.fanstatics.heroes;

import io.codeforall.fanstatics.abilities.ShieldBlock;

public class Warrior extends Hero{
    public Warrior() {
        super(200, 60, 30, 50, 40, new ShieldBlock(), "Warrior");
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
