package io.codeforall.fanstatics;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {

            WordsFile wordsFile = new WordsFile("resources/file.txt");

            for(String word : wordsFile) {
                System.out.println(word);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
