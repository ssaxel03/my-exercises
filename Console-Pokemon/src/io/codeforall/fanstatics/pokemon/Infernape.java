package io.codeforall.fanstatics.pokemon;

import java.util.ArrayList;
import java.util.Arrays;

public class Infernape extends PokemonAbstract{
    public Infernape() {
        super("Infernape",
                PokemonType.FIRE,
                new ArrayList<>(Arrays.asList(Move.EMBER, Move.FLAMETHROWER, Move.QUICK_ATTACK, Move.FIRE_BLAST)),
                76,
                104,
                71,
                108);
    }
}
