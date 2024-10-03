package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.Randomizer;

public class CarFactory {

    public static  Car getNewCar() {


        return switch (CarType.values()[Randomizer.getRandomInt(CarType.values().length)]) {
            case MITSUBISHI -> new Mitsubishi();
            case TOYOTA -> new Toyota();
            case NISSAN -> new Nissan();
            case HONDA -> new Honda();
        };

    }
}
