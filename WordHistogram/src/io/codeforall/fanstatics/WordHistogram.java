package io.codeforall.fanstatics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class WordHistogram implements Iterable{

    private HashMap<String, Integer> hashMap;

    public WordHistogram(String sentence) {

        this.hashMap = new HashMap<>();
        String[] stringArray = sentence.split(" ");

        for(String word : stringArray) {
            if(hashMap.containsKey(word)) {
                hashMap.replace(word, hashMap.get(word) + 1);
                continue;
            }

            hashMap.put(word, 1);
        }

    }

    @Override
    public Iterator iterator() {
        return this.hashMap.keySet().iterator();
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }

    public HashMap<String, Integer> getHashMap() {
        return hashMap;
    }
}
