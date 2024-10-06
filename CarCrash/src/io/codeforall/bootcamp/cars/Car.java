package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.field.Field;
import io.codeforall.bootcamp.field.Position;
import io.codeforall.bootcamp.Randomizer;

abstract  public class Car {

    /** The position of the car on the grid */
    private Position getPos;

    private String letter;
    private int velocity;
    private boolean hasCrashed;
    private boolean hasMechanicFollow;

    public Car(String letter) {
        this.letter = letter;
        this.velocity = 3;
        this.hasCrashed = false;
        this.hasMechanicFollow = false;
        // System.out.println(Randomizer.getRandomInt(Field.getWidth()));
        getPos = new Position(Randomizer.getRandomInt(Field.getWidth()), Randomizer.getRandomInt(Field.getHeight()));
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public Position getPos() {
        return getPos;
    }

    public void move(int frame){

        if (this.getHasCrashed()){
            return;
        }

        if (frame % this.velocity != 0) {
            return;
        }
        while(true) {
            switch (Direction.values()[Randomizer.getRandomInt(4)]) {
                case UP -> {
                    if (this.getPos.getRow() - 1 > -1) {
                        this.getPos.incRow(- 1);
                        return;
                    }
                }
                case DOWN -> {
                    if (this.getPos.getRow() + 1 < Field.getHeight()) {
                        this.getPos.incRow(1);
                        return;
                    }
                }
                case LEFT -> {
                    if (this.getPos.getCol() - 1 > -1) {
                        this.getPos.incCol(- 1);
                        return;
                    }
                }
                case RIGHT -> {
                    if (this.getPos.getCol() + 1 < Field.getWidth()) {
                        this.getPos.incCol(1);
                        return;
                    }
                }
            }
        }
    }

    public boolean getHasCrashed() {
        return this.hasCrashed;
    }

    public void crash() {
        this.hasCrashed = true;
        this.hasMechanicFollow = false;
    }

    public void repair() {
        this.hasCrashed = false;
        this.hasMechanicFollow = false;
    }

    @Override
    public String toString() {
        return (this.hasCrashed) ? "C" : letter;
    }

    public boolean getHasMechanicFollow() {
        return this.hasMechanicFollow;
    }

    public void Follow() {
        this.hasMechanicFollow = true;
    }

    public void getDebug() {
        System.out.printf("Car %s at x %d y %d %s %s%n",
                this.letter,
                this.getPos.getCol(),
                this.getPos.getRow(),
                this.hasCrashed,
                this.hasMechanicFollow);
    }
}
