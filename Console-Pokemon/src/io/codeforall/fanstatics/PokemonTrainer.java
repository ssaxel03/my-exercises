package io.codeforall.fanstatics;

import io.codeforall.fanstatics.pokemon.Move;
import io.codeforall.fanstatics.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Arrays;

public class PokemonTrainer {

    private String name;
    private ArrayList<Pokemon> pokemon;
    private Pokemon selectedPokemon;

    public PokemonTrainer(String name, Pokemon[] pokemon) {
        this.name = name;
        this.pokemon = new ArrayList<>(Arrays.asList(pokemon));
        this.selectedPokemon = this.pokemon.get(0);
    }

    public void attack(PokemonTrainer target, int moveIndex) {
        this.selectedPokemon.attack(target.getSelectedPokemon(), this.getSelectedPokemon().getMove(moveIndex));
    }

    public Pokemon getSelectedPokemon() {
        return this.selectedPokemon;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Pokemon> getPokemon() {
        return this.pokemon;
    }
    public String[] getPokemonOptions() {
        String[] pokemonOptions = new String[pokemon.size()];
        for (int i = 0; i < pokemon.size(); i++) {
            pokemonOptions[i] = getPokemonDescription(i);
        }
        return pokemonOptions;
    }

    private String getPokemonDescription(int index) {
        return this.getPokemon().get(index).getName() +
                " - health " + this.getPokemon().get(index).getHealth() +
                " type " + this.getPokemon().get(index).getType().toString()
                ;
    }
    public void setSelectedPokemon(int index) {
        this.selectedPokemon = pokemon.get(index);
    }

}
