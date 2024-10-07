package io.codeforall.bootcamp.gameobject;

public enum BarrelType {
    PLASTIC(2, "Plastic"),
    WOOD(1, "Wood"),
    METAL(3, "Metal");

    BarrelType(int maxDamage, String type) {
        this.maxDamage = maxDamage;
        this.type = type;
    }

    private String type;
    private int maxDamage;

    public int getMaxDamage() {
        return this.maxDamage;
    }

    public String toString() {
        return this.type;
    }
}
