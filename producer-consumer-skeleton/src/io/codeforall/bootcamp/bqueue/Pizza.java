package io.codeforall.bootcamp.bqueue;

public class Pizza {

    private Topping topping;

    public Pizza(){
        topping = Topping.values()[(int)(Math.random() * Topping.values().length)];
    }

    @Override
    public String toString() {
        return "A " + topping.name() + " pizza";
    }

    private enum Topping {
        PEPPERONI,
        MEXICAN,
        MUSHROOM,
        PEPPERS,
        EXTRA_CHEESE;
    }
}
