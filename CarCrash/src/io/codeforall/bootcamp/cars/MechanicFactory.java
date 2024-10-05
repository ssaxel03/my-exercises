package io.codeforall.bootcamp.cars;

public class MechanicFactory extends CarFactory{

    public static Mechanic getNewMechanic(){
        return new Mechanic();
    }
}
