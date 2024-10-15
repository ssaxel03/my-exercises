package io.codeforall.fanstatics;

public class Main {

    public static void main(String[] args) {

        String sentence = "eu ontem fui pescar com o Gonçalo e eu e o Gonçalo divertimo-nos muito a pescar";

        WordHistogram wordHistogram = new WordHistogram(sentence);

        for(Object key : wordHistogram) {
            System.out.println(key + ": " + wordHistogram.getHashMap().get(key));
        }

    }

}
