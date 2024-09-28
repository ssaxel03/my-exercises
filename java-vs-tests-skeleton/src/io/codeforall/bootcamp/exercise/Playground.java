package io.codeforall.bootcamp.exercise;

public class Playground {

    public static void main(String[] args) {

        Ai ai = new Ai("test", "today");

        String input = "Bob ! Hey you there.";

        String result = ai.palindromeReplace(input);
        System.out.println(result);
    }

}
