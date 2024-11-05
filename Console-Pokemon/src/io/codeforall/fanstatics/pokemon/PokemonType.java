package io.codeforall.fanstatics.pokemon;

public enum PokemonType {
    FIRE,
    WATER,
    GRASS,
    NORMAL;

    public static float getMultiplier(Pokemon attacker, Pokemon target) {
        return switch (attacker.getType()) {
            case FIRE -> switch (target.getType()) {
                case FIRE, WATER -> 0.5f;
                case GRASS -> 2f;
                default -> 1f;
            };
            case WATER -> switch (target.getType()) {
                case FIRE -> 2f;
                case WATER, GRASS -> 0.5f;
                default -> 1f;
            };
            case GRASS -> switch (target.getType()) {
                case FIRE, GRASS -> 0.5f;
                case WATER -> 2f;
                default -> 1f;
            };
            default -> switch (target.getType()) {
                case FIRE, WATER, GRASS -> 1f;
                default -> 0.5f;
            };
        };
    }
}
