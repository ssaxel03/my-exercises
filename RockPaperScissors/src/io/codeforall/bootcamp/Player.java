package io.codeforall.bootcamp;

public class Player {
    private final String name;
    private Move currentMove;
    private int wins;

    public Player(String name) {
        this.name = name;
        this.wins = 0;
    }

    public String getName() {
        return name;
    }

    public Move getCurrentMove() {
        return currentMove;
    }

    public void setCurrentMove(Move currentMove) {
        this.currentMove = currentMove;
    }

    public int getWins() {
        return wins;
    }

    public void incWins() {
        this.wins++;
    }
}
