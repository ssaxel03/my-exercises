package io.codeforall.fanstatics.pokemon;

public enum PokemonType {
    FIRE,
    WATER,
    GRASS,
    NORMAL;

    public static float getMultiplier(PokemonType move, PokemonType target) {
        return switch (move) {
            case FIRE -> switch (target) {
                case FIRE, WATER -> 0.5f;
                case GRASS -> 2f;
                default -> 1f;
            };
            case WATER -> switch (target) {
                case FIRE -> 2f;
                case WATER, GRASS -> 0.5f;
                default -> 1f;
            };
            case GRASS -> switch (target) {
                case FIRE, GRASS -> 0.5f;
                case WATER -> 2f;
                default -> 1f;
            };
            default -> switch (target) {
                case FIRE, WATER, GRASS -> 1f;
                default -> 0.5f;
            };
        };
    }
}
