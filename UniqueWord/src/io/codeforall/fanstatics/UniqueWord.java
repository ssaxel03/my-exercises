package io.codeforall.fanstatics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class UniqueWord implements Iterable<String>{

    HashSet<String> set;

    public UniqueWord(String string) {
        this.set = new HashSet<>();
        String array[] = string.split(" ");
        set.addAll(Arrays.stream(array).toList());
    }

    @Override
    public Iterator<String> iterator() {
        return set.iterator();
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<String> spliterator() {
        return Iterable.super.spliterator();
    }
}
