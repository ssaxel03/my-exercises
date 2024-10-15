package io.codeforall.fanstatics;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Range r = new Range(-5, 5);

        System.out.println("--- USING ITERATOR ---");
        Iterator<Integer> it = r.iterator();
        Iterator<Integer> itBack = r.iteratorBack();

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

        System.out.println("--- USING ITERATOR BACKWARDS ---");

        // iterator backwards
        while (itBack.hasNext()) {

            Integer i = itBack.next();

            if (i == 1 || i == 2 || i == 3) {
                itBack.remove();
            }
        }

        // ITERAR
        for (Integer j : r) {
            System.out.println("Iterated: " + j);
        }

    }
}
