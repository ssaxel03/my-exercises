package io.codeforall.bootcamp.car;

import io.codeforall.bootcamp.grid.Grid;

/**
 * A factory of different types of Cars
 */
public class CarFactory {

    /**
     * Manufactures new random cars
     *
     * @return a newly instantiated car
     */
    public static Car getNewCar(Grid grid) {

        int random = (int) (Math.random() * CarType.values().length);
        CarType carType = CarType.values()[random];

        Car car;

        switch (carType) {
            case FIAT:
                car = new Fiat(grid.makeGridPosition());
                break;
            case MUSTANG:
                car = new Mustang(grid.makeGridPosition());
                break;
            default:
                car = new Fiat(grid.makeGridPosition());
        }

        return car;

    }

}
