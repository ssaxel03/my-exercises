package io.codeforall.fanstatics;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Range r = new Range(-5, 5);

        System.out.println("--- USING ITERATOR ---");
        Iterator<Integer> it = r.iterator();

        // REMOVER
        while (it.hasNext()) {

            Integer i = it.next();

            if (i == 1 || i == 2 || i == 3) {
                it.remove();
            }
        }

        // ITERAR
        for (Integer j : r) {
            System.out.println("Iterated: " + j);
        }

        r.toggleUseForward();

        System.out.println("--- USING ITERATOR BACKWARDS ---");

        r = new Range(-5, 5);
        it = r.iterator();

        while (it.hasNext()) {

            Integer i = it.next();

            if (i == 1 || i == 2 || i == 3) {
                it.remove();
            }
        }

        // ITERAR
        for (Integer j : r) {
            System.out.println("Iterated: " + j);
        }

    }
}
