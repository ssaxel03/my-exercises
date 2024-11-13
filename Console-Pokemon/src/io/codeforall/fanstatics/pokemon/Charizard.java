package io.codeforall.fanstatics.pokemon;

import java.util.ArrayList;
import java.util.Arrays;

public class Charizard extends PokemonAbstract{
    public Charizard() {
        super("Charizard",
                PokemonType.FIRE,
                new ArrayList<>(Arrays.asList(Move.EMBER, Move.FIRE_BLAST, Move.FLAMETHROWER, Move.HEAT_WAVE)),
                78,
                84,
                78,
                100);
    }
}
