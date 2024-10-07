package io.codeforall.bootcamp.gameobject;

public class Barrel extends GameObject implements Destroyable{

    private BarrelType barrelType;
    private int currentDamage;
    private boolean destroyed;

    public Barrel(BarrelType barrelType) {
        this.barrelType = barrelType;
        this.currentDamage = 0;
        this.destroyed = false;
    }

    public void hit(int damage) {
        currentDamage = currentDamage + damage;

        if(currentDamage >= barrelType.getMaxDamage()) {
            this.destroyed = true;
        }

    }

    public boolean isDestroyed() {
        return this.destroyed;
    }

    public String getMessage() {
        return String.format("%s Barrel spotted", this.barrelType.toString());
    }


}
