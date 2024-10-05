package io.codeforall.bootcamp;

import io.codeforall.bootcamp.cars.Car;
import io.codeforall.bootcamp.cars.CarFactory;
import io.codeforall.bootcamp.cars.Mechanic;
import io.codeforall.bootcamp.cars.MechanicFactory;
import io.codeforall.bootcamp.field.Field;

public class Game {

    public static final int MANUFACTURED_CARS = 200;
    public static final int MANUFACTURED_MECHANICS = 30;

    /** Container of Cars */
    private Car[] cars;
    private Mechanic[] mechanics;

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

        mechanics = new Mechanic[MANUFACTURED_MECHANICS];
        for(int i = 0; i < mechanics.length; i++) {
            mechanics[i] = MechanicFactory.getNewMechanic();
        }
        cars = new Car[MANUFACTURED_CARS];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = CarFactory.getNewCar();
        }

        Field.draw(cars, mechanics);

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

            for(Car car : cars) {
                car.getDebug();
            }

            // Verify crashes
            checkCrashes();

            for(Car car : cars) {
                car.getDebug();
            }

            // Verify repairs
            checkRepairs();

            for(Car car : cars) {
                car.getDebug();
            }

            // Update screen
            Field.draw(cars, mechanics);

        }

    }

    private void moveAllCars() {

        for(Car car : cars) {
            car.move(this.frame);
        }
        for (Mechanic mechanic : mechanics) {
            mechanic.move(this.frame, cars);
        }
    }

    private void checkCrashes() {

        for (Car car1 : cars) {
            for(Car car2 : cars) {
                if(car1.equals(car2)) continue;

                if(car1.getPos().equals(car2.getPos())){
                    car1.crash();
                    car2.crash();
                }
            }
        }

    }

    private void checkRepairs() {
        for(Mechanic mechanic : mechanics) {
            for(Car car : cars) {
                if(mechanic.getPos().equals(car.getPos())) {
                    car.repair();
                    mechanic.repair();
                }
            }
        }
    }

    public Car[] getCars() {
        return cars;
    }

}
