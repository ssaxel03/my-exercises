package io.codeforall.bootcamp;

public class Program {
    public static void main(String[] args) {

        Player player1 = new Player("Pedro Morais");
        Player player2 = new Player("Axel Soares");

        System.out.println("Start of game");

        int limit = (Game.MAX_ROUNDS / 2) + 1;

        while(!(player1.getWins() == limit || player2.getWins() == limit)){



            System.out.println(player1.getName() + ": " + player1.getWins());
            System.out.println(player2.getName() + ": " + player2.getWins());

            player1.setCurrentMove(Move.values()[RandomGenerator.generateInt()]);
            player2.setCurrentMove(Move.values()[RandomGenerator.generateInt()]);

            Game.play(player1, player2);

        }

        if(player1.getWins() > player2.getWins()){
            System.out.println(player1.getName() + " is the game winner with " + player1.getWins() + " wins");
            return;
        }
        System.out.println(player2.getName() + " is the game winner with " + player2.getWins() + " wins");

    }
}
