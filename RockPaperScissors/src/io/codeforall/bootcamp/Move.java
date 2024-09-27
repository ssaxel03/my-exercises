package io.codeforall.bootcamp;

public enum Move {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors");

    private final String moveName;

    Move(String moveName) {
        this.moveName = moveName;
    }

    public String getMoveName() {
        return moveName;
    }
}
