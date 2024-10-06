package io.codeforall.bootcamp.cars;
import io.codeforall.bootcamp.Game;
import io.codeforall.bootcamp.field.Field;

public class Mechanic extends Car{

    private Car targetCar;

    public Mechanic() {
        super("M");
        this.targetCar = null;
    }

    public void move(int frame, Car[] cars) {

        if (frame % this.getVelocity() != 0) {
            return;
        }

        int tries = 0;
        int distance = Field.getHeight() + Field.getWidth();

        while(tries != 2) {
            if (targetCar != null) {

                if(targetCar.getHasCrashed()) {

                    if (
                            Math.abs(this.getPos().getCol() - targetCar.getPos().getCol()) >
                                    Math.abs(this.getPos().getRow() - targetCar.getPos().getRow())) {
                        if (this.getPos().getCol() - targetCar.getPos().getCol() > 0) {
                            this.getPos().incCol(-1);
                            return;
                        }
                        this.getPos().incCol(1);
                        return;
                    }

                    if (this.getPos().getRow() - targetCar.getPos().getRow() > 0) {
                        this.getPos().incRow(-1);
                        return;
                    }
                    this.getPos().incRow(1);
                    return;

                }
                /*
                if (Math.abs(this.getPos().getCol() - targetCar.getPos().getCol()) == 0) {
                    if (this.getPos().getRow() - targetCar.getPos().getRow() > 0) {
                        this.getPos().incRow(-1);
                        return;
                    }
                    this.getPos().incRow(1);
                    return;
                }
                if (Math.abs(this.getPos().getRow() - targetCar.getPos().getRow()) == 0) {
                    if(this.getPos().getCol() - targetCar.getPos().getCol() > 0) {
                        this.getPos().incCol(-1);
                        return;
                    }
                    this.getPos().incCol(1);
                    return;
                }
                */



            }

            for (Car car : cars) {
                if (car.getHasCrashed() && !car.getHasMechanicFollow()) {
                    if(this.getPos().getDIstance(car.getPos()) < distance) {
                        this.targetCar = car;
                        car.Follow();
                        distance = this.getPos().getDIstance(car.getPos());
                    }
                }
            }
            tries++;
        }
    }

    @Override
    public void repair() {
        this.targetCar = null;
    }

}
