package io.codeforall.fanstatics.pokemon;

public interface Pokemon {

    public void attack(Pokemon target, Move move);
    public void hit(Pokemon attacker, int damage);
    public PokemonType getType();

}
