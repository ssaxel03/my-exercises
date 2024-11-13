package io.codeforall.fanstatics;

import io.codeforall.fanstatics.pokemon.Charizard;
import io.codeforall.fanstatics.pokemon.Infernape;
import io.codeforall.fanstatics.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static ArrayList<Pokemon> pokemons = new ArrayList<>(Arrays.asList(
            new Charizard(),
            new Infernape()
    ));

    public static void main(String[] args) {

        /*
        PokemonTrainer player = new PokemonTrainer("Axel", new Pokemon[]{new Charizard(), new Infernape()});
        PokemonTrainer opponent = new PokemonTrainer("Jorge", new Pokemon[]{new Charizard()});

        player.attack(opponent, 3);
         */

        new Battle().fight();
    }
}
