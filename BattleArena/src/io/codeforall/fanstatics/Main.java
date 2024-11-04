package io.codeforall.fanstatics;

import io.codeforall.fanstatics.heroes.Hero;

public class Main {
    public static void main(String[] args) {

        int warrior = 0;
        int mage = 0;
        int cleric = 0;
        int rogue = 0;

        for (int i = 0; i < 100; i++) {
            Hero winner = new Arena().play();
            switch (winner.getClass().getSimpleName()) {
                case "Warrior":
                    warrior++;
                    break;
                case "Mage":
                    mage++;
                    break;
                case "Cleric":
                    cleric++;
                    break;
                case "Rogue":
                    rogue++;
                    break;
            }
        }

        System.out.println("Warrior: " + warrior);
        System.out.println("Mage: " + mage);
        System.out.println("Cleric: " + cleric);
        System.out.println("Rogue: " + rogue);

    }
}
