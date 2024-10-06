package io.codeforall.bootcamp.cars;

public class MotorcycleFactory extends CarFactory{

    public static Motorcycle getNewMotorcycle() {
        return new Motorcycle();
    }

}
