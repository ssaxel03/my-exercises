package io.codeforall.fanstatics.pokemon;

public interface Pokemon {

    public void attack(Pokemon target, Move move);
    public void hit(Pokemon attacker, Move move);
    public String getName();
    public PokemonType getType();
    public Move getMove(int moveIndex);
    public String[] getMoves();
    public int getHealth();
    public int getSpeed();
    public String getDescription();
    public boolean isDead();

}
