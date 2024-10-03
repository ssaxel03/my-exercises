package io.codeforall.bootcamp;

import io.codeforall.bootcamp.cars.Car;
import io.codeforall.bootcamp.cars.CarFactory;
import io.codeforall.bootcamp.field.Field;

public class Game {

    public static final int MANUFACTURED_CARS = 100;

    /** Container of Cars */
    private Car[] cars;

    /** Animation delay */
    private int delay;
    private int frame;

    public Game(int cols, int rows, int delay) {

        this.frame = 0;
        Field.init(cols, rows);
        this.delay = delay;

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        cars = new Car[MANUFACTURED_CARS];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = CarFactory.getNewCar();
        }

        Field.draw(cars);

    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (true) {

            this.frame++;

            // Pause for a while
            Thread.sleep(delay);

            // Move all cars
            moveAllCars();

            // Verify crashes
            checkCrashes();

            // Update screen
            Field.draw(cars);

        }

    }

    private void moveAllCars() {

        for(Car car : cars) {
            car.move(this.frame);
        }
    }

    private void checkCrashes() {

        for (Car car1 : cars) {
            for(Car car2 : cars) {
                if(car1.equals(car2)) break;

                if(car1.getPos().equals(car2.getPos())){
                    car1.crash();
                    car2.crash();
                }
            }
        }

    }

}
