package io.codeforall.fanstatics.abilities;

import io.codeforall.fanstatics.heroes.Hero;

public class ShieldBlock extends AbstractAbility {
    private int shieldDuration;
    private boolean active;
    public ShieldBlock() {
        super(25, 120, 10, "Shield Block");
        this.shieldDuration = (int) (super.coolDownTurns / 2);
        this.active  = false;
    }

    @Override
    public void use(int currentTurn, Hero target) {
        System.out.println("WARRIOR USES HIS SHIELD TO BLOCK");
        this.setLastUsed(currentTurn);
        target.raiseDefense(this.getPower());
        this.active = true;
    }

    public void update(int currentTurn, Hero target) {
        if(this.lastUsed + this.shieldDuration <= currentTurn && this.active) {
            target.raiseDefense( - this.getPower());
            this.active = false;
        }
    }
}
