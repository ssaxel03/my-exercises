package io.codeforall.fanstatics;

import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        final String message = "I'll send an SOS to the garbage world, " +
                "I hope that someone garbage gets my message in a garbage bottle.";

        System.out.println(Arrays.stream(message.split(" "))
                .map(String::toUpperCase)
                .filter(word -> !Objects.equals(word, "GARBAGE"))
                .reduce("", (acc, elem) -> acc + " " + elem));


    }

}
