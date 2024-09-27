package io.codeforall.bootcamp;

public class Game {

    public final static int MAX_ROUNDS = 3;

    public static void play(Player player1, Player player2) {

        // compare moves

        System.out.println(player1.getName() + " played " + player1.getCurrentMove().getMoveName());
        System.out.println(player2.getName() + " played " + player2.getCurrentMove().getMoveName());

        if(Move.getWinner(player1.getCurrentMove(), player2.getCurrentMove()) == 1) {
            System.out.println(player1.getName() + " wins");
            player1.incWins();
            return;
        }
        if(Move.getWinner(player1.getCurrentMove(), player2.getCurrentMove()) == 2) {
            System.out.println(player2.getName() + " wins");
            player2.incWins();
            return;
        }

        System.out.println("It's a draw");


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



}
