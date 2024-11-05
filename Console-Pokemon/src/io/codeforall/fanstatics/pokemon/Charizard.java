package io.codeforall.fanstatics.pokemon;

import java.util.Collections;
import java.util.HashSet;

public class Charizard extends PokemonAbstract{
    public Charizard() {
        super("Charizard",
                PokemonType.FIRE,
                new HashSet<Move>(),
                //Move.EMBER, Move.FIRE_BLAST, Move.FLAMETHROWER, Move.HEAT_WAVE)
                78,
                84,
                78,
                100);
    }
}
