package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.Randomizer;
import io.codeforall.bootcamp.field.Field;
import io.codeforall.bootcamp.field.Position;

public class Motorcycle extends Car{

    public Motorcycle() {
        super("M");
        this.setVelocity(2);
    }

    public void move(int frame, Car[] cars) {
        if (frame % this.getVelocity() != 0) {
            return;
        }

        while(true) {
            switch (Direction.values()[Randomizer.getRandomInt(4)]) {
                case UP -> {
                    if (this.getPos().getRow() - 1 > -1 && !getCarsInPosition(this.getPos().getCol(), this.getPos().getRow() - 1, cars)) {
                        this.getPos().incRow(- 1);
                        return;
                    }
                }
                case DOWN -> {
                    if (this.getPos().getRow() + 1 < Field.getHeight() && !getCarsInPosition(this.getPos().getCol(), this.getPos().getRow() + 1, cars)) {
                        this.getPos().incRow(1);
                        return;
                    }
                }
                case LEFT -> {
                    if (this.getPos().getCol() - 1 > -1 && !getCarsInPosition(this.getPos().getCol() - 1, this.getPos().getRow(), cars)) {
                        this.getPos().incCol(- 1);
                        return;
                    }
                }
                case RIGHT -> {
                    if (this.getPos().getCol() + 1 < Field.getWidth() && !getCarsInPosition(this.getPos().getCol() + 1, this.getPos().getRow(), cars)) {
                        this.getPos().incCol(1);
                        return;
                    }
                }
            }
        }
    }

    private boolean getCarsInPosition(int positionCol, int positionRow, Car[] cars) {

        Position position = new Position(positionCol, positionRow);

        for(Car car : cars) {
            if(car.getPos().equals(position)) {
                return true;
            }
        }

        return false;

    }

}
