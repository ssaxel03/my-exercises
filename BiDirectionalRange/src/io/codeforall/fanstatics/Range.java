package io.codeforall.fanstatics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Range implements Iterable<Integer> {

    private boolean[] rangeArray;
    private Iterator<Integer> iterator;
    int initial;
    int last;
    boolean useForward;

    public Range(int initial, int last) {
        int size = last - initial + 1;
        this.rangeArray = new boolean[size];

        Arrays.fill(rangeArray, true);

        this.initial = initial;
        this.last = last;

        useForward = true;

    }

    @Override
    public Iterator<Integer> iterator() {

        if (!useForward) {

            return new Iterator<Integer>() {
                int currentI = rangeArray.length;

                @Override
                public boolean hasNext() {
                    return currentI > 0;
                }

                @Override
                public Integer next() {
                    currentI--;
                    return (rangeArray[currentI]) ? currentI + Math.abs(initial) : next();
                }

                @Override
                public void remove() {
                    rangeArray[currentI] = false;
                }
            };
        }


            return new Iterator<Integer>() {
                int currentI = initial - 1;

                @Override
                public boolean hasNext() {
                    return currentI < last;
                }

                @Override
                public Integer next() {
                    currentI++;
                    return (rangeArray[currentI - initial]) ? currentI : next();
                }

                @Override
                public void remove() {
                    rangeArray[currentI - initial] = false;
                }
            };
    }

    public void toggleUseForward() {
        this.useForward = !this.useForward;
    }
}