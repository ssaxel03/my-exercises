package Range;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class RangeTest implements Iterable<Integer> {

    private Iterator<Integer> iterator;

    public RangeTest(int initial, int last) {

        iterator = new RangeIterator(initial, last);

    }
    @Override
    public Iterator<Integer> iterator() {

        return this.iterator;
    }
}
