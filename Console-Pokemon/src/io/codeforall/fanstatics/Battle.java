package io.codeforall.fanstatics;

import io.codeforall.fanstatics.pokemon.Pokemon;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Battle {

    Prompt prompt;
    PokemonTrainer player;
    PokemonTrainer opponent;
    ArrayList<PokemonTrainer> trainers;
    private boolean noWinner;

    public Battle() {

        prompt = new Prompt(System.in, System.out);

        StringInputScanner name = new StringInputScanner();
        name.setMessage("Type your name: ");

        player = new PokemonTrainer(prompt.getUserInput(name), getRandomPokemon());
        opponent = new PokemonTrainer("Jorge", getRandomPokemon());

        trainers = new ArrayList<>();
        trainers.add(player);
        trainers.add(opponent);

        this.noWinner = true;

    }

    public void fight() {

        System.out.println("Welcome to the battle, " + player.getName());
        System.out.println("Your opponent is " + opponent.getName());

        System.out.println();

        System.out.println(player.getName() + "'s pokemon: " + player.getSelectedPokemon().getDescription());
        System.out.println(opponent.getName() + "'s pokemon: " + opponent.getSelectedPokemon().getDescription());

        while(noWinner) {
            turn();
        }

    }

    public Pokemon[] getRandomPokemon() {

        int amount = (int) (Math.random() * 6);
        Pokemon[] pokemon = new Pokemon[amount];

        for (int i = 0; i < amount; i++) {
            int index = (int) (Math.random() * Main.pokemons.size());
            pokemon[i] = Main.pokemons.get(index) ;
        }

        return pokemon;

    }
    public void turn() {


        MenuInputScanner moves = new MenuInputScanner(player.getSelectedPokemon().getMoves());
        moves.setMessage("Choose which move to use:");
        moves.setError("Invalid move");
        int moveIndex = prompt.getUserInput(moves) - 1;
        int opponentMoveIndex = (int) (Math.random() * 4);

        if(trainers.get(0).getSelectedPokemon().getSpeed() < trainers.get(1).getSelectedPokemon().getSpeed()) {
            Collections.reverse(trainers);
        }

        if(!trainers.get(0).getSelectedPokemon().isDead()) {
            trainers.get(0).attack(trainers.get(0), moveIndex);
        }
        if(!trainers.get(1).getSelectedPokemon().isDead()) {
            trainers.get(1).attack(trainers.get(1), opponentMoveIndex);
        }

        System.out.println();

        System.out.println(player.getName() + "'s pokemon: " + player.getSelectedPokemon().getDescription());
        System.out.println(opponent.getName() + "'s pokemon: " + opponent.getSelectedPokemon().getDescription());

        System.out.println();

        if(player.getSelectedPokemon().isDead() || opponent.getSelectedPokemon().isDead()) {
            checkWinner();
        }
    }
    private void checkWinner() {

        int playerPokemonAlive = 0;
        int opponentPokemonAlive = 0;

        for (Pokemon pokemon : player.getPokemon()) {
            if(!pokemon.isDead()) {
               playerPokemonAlive++;
            }
        }
        for(Pokemon pokemon : opponent.getPokemon()) {
            if(!pokemon.isDead()) {
                opponentPokemonAlive++;
            }
        }

        if(playerPokemonAlive == 0) {
            System.out.println(opponent.getName() + " wins");
            this.noWinner = false;
            return;
        }

        if(opponentPokemonAlive == 0) {
            System.out.println(player.getName() + " wins");
            this.noWinner = false;
            return;
        }

        while(player.getSelectedPokemon().isDead()) {
            MenuInputScanner nextPokemon = new MenuInputScanner(player.getPokemonOptions());
            nextPokemon.setMessage("Choose which pokemon to use next");
            nextPokemon.setError("Invalid pokemon");

            player.setSelectedPokemon(prompt.getUserInput(nextPokemon) - 1);
        }

        while(opponent.getSelectedPokemon().isDead()) {
            opponent.setSelectedPokemon((int) (Math.random() * opponent.getPokemon().size()));
        }

    }
}
