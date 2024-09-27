package io.codeforall.bootcamp;

public class Game {

    public final static int MAX_ROUNDS = 3;

    public static void play() {

        Player player1 = new Player("Pedro Morais");
        Player player2 = new Player("Axel Soares");

        System.out.println("Start of game");

        int limit = (Game.MAX_ROUNDS / 2) + 1;

        System.out.println(limit+"");

        // compare moves
        while(!(player1.getWins() == limit || player2.getWins() == limit)) {

            System.out.println(player1.getName() + ": " + player1.getWins());
            System.out.println(player2.getName() + ": " + player2.getWins());

            player1.setCurrentMove(Move.values()[RandomGenerator.generateInt()]);
            player2.setCurrentMove(Move.values()[RandomGenerator.generateInt()]);

            System.out.println(player1.getName() + " played " + player1.getCurrentMove().getMoveName());
            System.out.println(player2.getName() + " played " + player2.getCurrentMove().getMoveName());

            comparisons(player1, player2);

        }

        if(player1.getWins() > player2.getWins()){
            System.out.println(player1.getName() + " is the game winner with " + player1.getWins() + " wins");
            return;
        }
        System.out.println(player2.getName() + " is the game winner with " + player2.getWins() + " wins");


        /*

        if (player1.getCurrentMove() == player2.getCurrentMove()) {
            System.out.println("It's a draw");
            return;
        }

        if (player1.getCurrentMove() == Move.ROCK) {
            if(player2.getCurrentMove() == Move.SCISSORS) {
                System.out.println(player1.getName() + " wins");
                player1.incWins();
                return;
            }
            System.out.println(player2.getName() + " wins");
            player2.incWins();
            return;
        }

        if (player1.getCurrentMove() == Move.PAPER) {
            if(player2.getCurrentMove() == Move.ROCK) {
                System.out.println(player1.getName() + " wins");
                player1.incWins();
                return;
            }
            System.out.println(player2.getName() + " wins");
            player2.incWins();
            return;
        }

        if (player1.getCurrentMove() == Move.SCISSORS) {
            if(player2.getCurrentMove() == Move.PAPER) {
                System.out.println(player1.getName() + " wins");
                player1.incWins();
                return;
            }
            System.out.println(player2.getName() + " wins");
            player2.incWins();
            return;
        }

        */

    }

    public static void comparisons(Player player1, Player player2) {

        if (Move.getWinner(player1.getCurrentMove(), player2.getCurrentMove()) == 1) {
            System.out.println(player1.getName() + " wins");
            player1.incWins();
            return;
        }
        if (Move.getWinner(player1.getCurrentMove(), player2.getCurrentMove()) == 2) {
            System.out.println(player2.getName() + " wins");
            player2.incWins();
            return;
        }

        System.out.println("It's a draw");

    }



}
