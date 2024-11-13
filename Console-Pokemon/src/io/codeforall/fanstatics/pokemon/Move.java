package io.codeforall.fanstatics.pokemon;

public enum Move {
    FLAMETHROWER(PokemonType.FIRE, 90, 100, 15),
    FIRE_BLAST(PokemonType.FIRE, 110, 85, 5),
    EMBER(PokemonType.FIRE, 40, 100, 25),
    HEAT_WAVE(PokemonType.FIRE, 95, 90, 10),

    WATER_GUN(PokemonType.WATER, 40, 100, 25),
    HYDRO_PUMP(PokemonType.WATER, 110, 80, 5),
    SURF(PokemonType.WATER, 90, 100, 15),
    WATERFALL(PokemonType.WATER, 80, 100, 15),

    RAZOR_LEAF(PokemonType.GRASS, 55, 95, 25),
    SOLAR_BEAM(PokemonType.GRASS, 120, 100, 10),
    VINE_WHIP(PokemonType.GRASS, 45, 100, 25),
    GIGA_DRAIN(PokemonType.GRASS, 75, 100, 10),

    TACKLE(PokemonType.NORMAL, 40, 100, 35),
    SWIFT(PokemonType.NORMAL, 60, 100, 20),
    QUICK_ATTACK(PokemonType.NORMAL, 40, 100, 30),
    HYPER_BEAM(PokemonType.NORMAL, 150, 90, 5);

    private final PokemonType type;
    private final int attack;
    private final int accuracy;
    private int limit;

    Move(PokemonType type, int attack, int accuracy, int limit) {
        this.type = type;
        this.attack = attack;
        this.accuracy = accuracy;
        this.limit = limit;
    }

    public PokemonType getType() {
        return type;
    }

    public int getAttack() {
        return attack;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getLimit() {
        return limit;
    }

    public void decLimit() {
        this.limit--;
    }
}

