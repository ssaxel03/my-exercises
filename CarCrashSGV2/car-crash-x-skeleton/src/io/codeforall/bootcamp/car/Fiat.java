package io.codeforall.bootcamp.car;

import io.codeforall.bootcamp.grid.position.GridPosition;

/**
 * Fiat is not a very fast or reliable car and may break after some time.
 */
public class Fiat extends Car {

    public final static int SPEED = 1;
    private final static int MOVES_BEFORE_BREAK = 30;
    private final static int BREAK_INTERVAL = 4;
    private int moves = 0;

    /**
     * Constructs a brand new Fiat
     *
     * @param pos the position of the car in the grid
     */
    public Fiat(GridPosition pos) {
        super(pos, CarType.FIAT);
    }

    /**
     * @see Car#move()
     */
    @Override
    public void move() {

        moves++;

        if (moves < MOVES_BEFORE_BREAK || moves % BREAK_INTERVAL != 0) {
            accelerate(chooseDirection(), Fiat.SPEED);
        }

    }
}
