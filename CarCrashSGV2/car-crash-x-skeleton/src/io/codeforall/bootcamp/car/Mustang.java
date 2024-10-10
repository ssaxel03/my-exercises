package io.codeforall.bootcamp.car;

import io.codeforall.bootcamp.grid.position.GridPosition;

/**
 * Mustang is a fast and reliable car
 */
public class Mustang extends Car {

    public final static int SPEED = 3;

    /**
     * Constructs a brand new Mustang
     *
     * @param pos the position of the car in the grid
     */
    public Mustang(GridPosition pos) {
        super(pos, CarType.MUSTANG);
    }

    /**
     * @see Car#move()
     */
    @Override
    public void move() {

        accelerate(chooseDirection(), Mustang.SPEED);

    }
}
