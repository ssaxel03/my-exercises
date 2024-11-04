package io.codeforall.fanstatics;

import io.codeforall.fanstatics.heroes.*;

import java.util.ArrayList;

public class Arena {
    ArrayList<Hero> heroes;
    public Arena() {
        heroes = new ArrayList<Hero>();
        heroes.add(new Warrior());
        heroes.add(new Mage());
        heroes.add(new Cleric());
        heroes.add(new Rogue());
    }

    public Hero play() {

        TurnManager turnManager = new TurnManager();

        while(!isOver()) {
            turnManager.nextTurn(heroes);
        }

        Hero winner = heroes.stream().filter(Hero::isAlive).findAny().get();

        System.out.println(winner.getName() + " wins!");
        return winner;

    }

    public boolean isOver() {
        int alive = 0;
        for (Hero hero : heroes) {
            if(hero.isAlive()) {
                alive++;
            }
        }
        return alive < 2;
    }
}
