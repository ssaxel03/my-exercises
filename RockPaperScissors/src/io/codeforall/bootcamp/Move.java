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

    public static int getWinner(Move move1, Move move2) {

        if (move1 == move2){
            return 0;
        }

        switch (move1) {
            case ROCK -> {
                if (move2 == PAPER) {
                    return 2;
                }
                return 1;
            }
            case PAPER -> {
                if (move2 == ROCK) {
                    return 1;
                }
                return 2;
            }
            case SCISSORS -> {
                if (move2 == ROCK) {
                    return 2;
                }
                return 1;
            }
        }

        return 0;
    }

}
