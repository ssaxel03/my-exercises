import java.util.Iterator;

import Range.RangeTest;

public class Main {

    public static void main(String[] args) {

        RangeTest r = new RangeTest(-5, 5);

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

    }
}
