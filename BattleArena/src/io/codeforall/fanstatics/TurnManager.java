package io.codeforall.fanstatics;

import io.codeforall.fanstatics.heroes.Hero;

import java.util.ArrayList;
import java.util.LinkedList;

public class TurnManager {

    private int currentTurn;
    private LinkedList<Hero> playOrder;

    public TurnManager() {
        this.currentTurn = 0;
    }

    public void nextTurn(ArrayList<Hero> heroes) {
        this.currentTurn++;

        System.out.println("TURN " + this.currentTurn);

        playOrder = this.getOrder(heroes);

        for (Hero hero : playOrder) {
            hero.play(currentTurn, this.getTarget(hero));
        }

        System.out.println();
    }

    private LinkedList<Hero> getOrder(ArrayList<Hero> heroes) {

        LinkedList<Hero> order = new LinkedList<>();

        ArrayList<Hero> toBeRemoved = new ArrayList<>(heroes);

        while(toBeRemoved.size() > 0) {

            order.add(toBeRemoved.remove( (int) (Math.random() * toBeRemoved.size()) ));
        }

        return order;

    }

    private Hero getTarget(Hero self) {
        Hero target = null;

        boolean flag = true;
        while(flag) {
            target = playOrder.get( (int) (Math.random() * playOrder.size()) );

            if(target.isAlive() && target != self) {
                flag = false;
            }

        }

        return target;
    }

}
